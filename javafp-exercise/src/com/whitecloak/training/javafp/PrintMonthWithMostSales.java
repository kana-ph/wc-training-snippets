package com.whitecloak.training.javafp;

import com.whitecloak.training.models.ItemModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jeremy Salve
 */

public class PrintMonthWithMostSales {

    public static void main(String[] args) throws IOException {

        Path pathManila = Paths.get("data_csv/manila.csv");
        Path pathCebu = Paths.get("data_csv/cebu.csv");
        Path pathDavao = Paths.get("data_csv/davao.csv");

        System.out.println("Print the month with the most number (units sold) of sales from all branches");
        printMonthWithMostSales(pathManila, pathCebu, pathDavao);
    }

    public static void printMonthWithMostSales(Path pathManila, Path pathCebu, Path pathDavao) throws IOException {

        Stream<String> itemStream = Stream.concat(Files.lines(pathManila), Files.lines(pathCebu));
        itemStream = Stream.concat(itemStream, Files.lines(pathDavao));

        String monthWithMostSoldItem = itemStream.filter(line -> !line.isBlank())
                .map(itemString -> itemString.split(","))
                .map(itemStringArray -> new ItemModel(itemStringArray[0], LocalDate.parse(itemStringArray[1], DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(itemStringArray[2]), new BigDecimal(itemStringArray[3])))
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(itemModel -> itemModel.getDate().toString().split("-")[1], Collectors.summingInt(ItemModel::getUnitsSold)),
                        map -> map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()));

        System.out.println(Month.of(Integer.parseInt(monthWithMostSoldItem)));
    }
}