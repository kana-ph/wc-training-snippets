package com.whitecloak.training.javafp;

import com.whitecloak.training.models.ItemModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Jeremy Salve
 */

public class PrintMostSoldItemInDavao {

    public static void main(String[] args) throws IOException {

        Path pathDavao = Paths.get("data_csv/davao.csv");

        System.out.println("Print the name of the most item sold in Davao");
        printMostSoldItemInDavao(pathDavao);
    }

    private static void printMostSoldItemInDavao(Path pathDavao) throws IOException {

        String mostItemSoldInDavao = Files.lines(pathDavao).filter(line -> !line.isBlank())
                .map(itemString -> itemString.split(","))
                .map(itemStringArray -> new ItemModel(itemStringArray[0], LocalDate.parse(itemStringArray[1], DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(itemStringArray[2]), new BigDecimal(itemStringArray[3])))
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(ItemModel::getName, Collectors.summingInt(ItemModel::getUnitsSold)),
                        map -> map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()));

        System.out.println(mostItemSoldInDavao);
    }
}