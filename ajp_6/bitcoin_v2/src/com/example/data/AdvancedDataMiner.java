package com.example.data;

import java.util.List;
import java.util.Map;

public class AdvancedDataMiner {
    private Object search_tree;

    public AdvancedDataMiner(Object search_tree) {
        this.search_tree = search_tree;
    }
    private String get_type(Object tree_element) {
        if(tree_element.getClass().getSimpleName().contains("Map")) {
            return "Map";
        } else if(tree_element.getClass().getSimpleName().contains("List")) {
            return "List";
        } else {
            return tree_element.getClass().getSimpleName();
        }
    }
    private Object find_map_value(NodeMetaData nodeMetaData, Map<String, Object> tree_branch) throws KeyNotFoundException {
        boolean isNodeFound = false;
        for(String key : tree_branch.keySet()) {
            if(key.equals(nodeMetaData.getNode_name())) {
                isNodeFound = true;
                break;
            }
        }
        if(!isNodeFound) throw new KeyNotFoundException(nodeMetaData.getNode_name());
        return tree_branch.get(nodeMetaData.getNode_name());
    }
    private Object find_list_value(NodeMetaData criteria, List<Object> tree_branch) {
        int i = Integer.parseInt(criteria.getNode_name());
        if (i < 0 || i >= tree_branch.size()) throw new ArrayIndexOutOfBoundsException();
        return tree_branch.get(i);
    }
    public Object find(NodeMetaData[] nodesMetaData) throws KeyNotFoundException {
        Object current_branch = search_tree;
        for(NodeMetaData nodeMetaData : nodesMetaData) {
            current_branch = switch (get_type(current_branch)) {
                case "Map" -> find_map_value(nodeMetaData, (Map<String, Object>) current_branch);
                case "List" -> find_list_value(nodeMetaData, (List<Object>) current_branch);
                default -> current_branch;
            };
        }
        return current_branch;
    }
}
