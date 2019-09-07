package com.whitecloak.training.javafp;

import com.whitecloak.training.models.ItemModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jeremy Salve
 */

public class PrintSortedSoldItems {

    public static void main(String[] args) throws IOException {

        Path pathManila = Paths.get("data_csv/manila.csv");
        Path pathCebu = Paths.get("data_csv/cebu.csv");
        Path pathDavao = Paths.get("data_csv/davao.csv");

        System.out.println("Print all the items sold in alphabetical order (no explicit sorting)");
        printSortedSoldItems(pathManila, pathCebu, pathDavao);
    }

    private static void printSortedSoldItems(Path pathManila, Path pathCebu, Path pathDavao) throws IOException {

        Stream<String> itemStream = Stream.concat(Files.lines(pathManila), Files.lines(pathCebu));
        itemStream = Stream.concat(itemStream, Files.lines(pathDavao));

        TreeSet<String> itemTreeSet = itemStream.filter(line -> !line.isBlank())
                .map(itemString -> itemString.split(","))
                .map(itemStringArray -> new ItemModel(itemStringArray[0], LocalDate.parse(itemStringArray[1], DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(itemStringArray[2]), new BigDecimal(itemStringArray[3])))
                .map(ItemModel::getName)
                .collect(Collectors.toCollection(TreeSet::new));

        itemTreeSet.forEach(System.out::println);
    }
}