package com.itsvet;
import com.itsvet.komponente.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Komponenta> komponente = new ArrayList();
        komponente.add(new Procesor(
                "i3-8100",
                "Intel",
                new BigDecimal("16590.00"),
                "IS108100i3",
                4,
                new BigDecimal("3.6")
        ));
        komponente.add(new Procesor(
                "Ryzen 3 PRO 4350G",
                "AMD",
                new BigDecimal("20590.00"),
                "IS03AMDR3P4350G",
                4,
                new BigDecimal("3.6")
        ));
        komponente.add(new Procesor(
                "i5-10600",
                "Intel",
                new BigDecimal("27996.00"),
                "IS03AMDR3P4350G",
                6,
                new BigDecimal("3.3")
        ));
        komponente.add(new GrafickaKarta(
                "GeForce RTX 3060 GAMING OC 12G",
                "Gigabyte",
                new BigDecimal("105999.00"),
                "ITGPURTX3060OC12",
                "GDDR6",
                12288,
                new BigDecimal("1430.00")
        ));
        komponente.add(new GrafickaKarta(
                "GeForce RTX 3070 GameRock",
                "Palit",
                new BigDecimal("115000.00"),
                "ITGPURTX3060OC12",
                "GDDR6",
                8196,
                new BigDecimal("1500.00")
        ));
        komponente.add(new RAM(
                "Viper 4 Series PV416G373C7K",
                "Patriot",
                new BigDecimal("12636.00"),
                "ITRAMV4PV416G37",
                16384,
                new BigDecimal("3733.00")
        ));
        komponente.add(new MaticnaPloca(
                "B460M PRO4",
                "ASRock",
                new BigDecimal("12106.00"),
                "ITMB288907ASRB450",
                "microATX",
                "Intel B460",
                "Intel"
        ));

        for(Komponenta k : komponente) {
            System.out.println(k);
        }

        System.out.println("== Maticne ploce sa Intel procesorom ==");
        for(Komponenta k : komponente) {
            if((k instanceof MaticnaPloca mb) &&
                    (mb.getProcesor().equals("Intel"))) {
                System.out.println(mb);
            }
        }
    }
}
