package com.example.data;

import java.util.HashMap;
import java.util.Map;

public class DataMiner {
    private HashMap<String, Object> mining_data_map;

    public DataMiner(HashMap<String, Object> mining_data) {
        this.mining_data_map = mining_data;
    }

    public Object find(Struktura[] drvo_pretrage) throws IncompatibleTypeException, KeyNotFoundException {
        /*
        * 1. bpi - Map
        * 2. EUR - Map
        * 3. float_rate - float
        * */
        Map<String, Object> mining_map = mining_data_map;
        for(Struktura grana : drvo_pretrage) {
            boolean keyFound = false;
            for(String key : mining_map.keySet()) {
                if(grana.getNaziv_polja().equals(key)) {
                    keyFound = true;
                    break;
                }
            }

            if(!keyFound) {
                throw new KeyNotFoundException(grana.getNaziv_polja());
            }
            Object objekat_za_kljuc = mining_map.get(grana.getNaziv_polja());
            if(!objekat_za_kljuc.getClass().getSimpleName().contains( grana.getTip_polja() )) {
                throw new IncompatibleTypeException(
                        objekat_za_kljuc.getClass().getSimpleName(),
                        grana.getTip_polja()
                );
            }
            if(grana.getTip_polja().equals("Map")) {
                mining_map = (Map<String, Object>) objekat_za_kljuc;
            } else {
                return objekat_za_kljuc;
            }
        }

        return null;
    }
}
