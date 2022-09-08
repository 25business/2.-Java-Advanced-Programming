package com.example;

import com.example.coindesk.CoinDeskHTTP;
import com.example.coindesk.MetaWeatherHTTP;
import com.example.data.*;

public class Program {
    public static void main(String[] args) {
        /*
        Struktura[] drvo_pretrage = new Struktura[] {
          new Struktura("bpi", "Map"),
          new Struktura("EUR", "Map"),
          new Struktura("rate_float", "Double")
        };
        */
        /*
        Struktura[] drvo_pretrage = new Struktura[] {
                new Struktura("bpi", "Map"),
                new Struktura("GBP", "Map"),
                new Struktura("description", "String")
        };
         */

        Struktura[] drvo_pretrage = new Struktura[] {
                new Struktura("time", "Map"),
                new Struktura("updatedISO", "String"),
        };
        try {
            DataMiner dataMiner = new DataMiner(CoinDeskHTTP.get_response_data());
            Object result = dataMiner.find(drvo_pretrage);
            System.out.println(result);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            NodeMetaData[] nodes_meta_info = new NodeMetaData[] {
                    new NodeMetaData("consolidated_weather", "List"),
                    new NodeMetaData("3", "Index"),
                    new NodeMetaData("weather_state_name", "String")
            };
            AdvancedDataMiner advancedDataMiner = new AdvancedDataMiner(MetaWeatherHTTP.get_response_data());
            Object result = advancedDataMiner.find(nodes_meta_info);
            System.out.println(result);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
