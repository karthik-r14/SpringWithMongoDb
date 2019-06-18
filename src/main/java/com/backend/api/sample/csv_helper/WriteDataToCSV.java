package com.backend.api.sample.csv_helper;

import com.backend.api.sample.model.Topic;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.PrintWriter;
import java.util.List;

public class WriteDataToCSV {

    public static void writeDataToCsvWithListObjects(PrintWriter writer, List<Topic> topics) {
        String[] CSV_HEADER = {"id", "name", "description"};

        StatefulBeanToCsv<Topic> beanToCsv = null;
        try (
                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            csvWriter.writeNext(CSV_HEADER);

            // write List of Objects
            ColumnPositionMappingStrategy<Topic> mappingStrategy =
                    new ColumnPositionMappingStrategy<Topic>();

            mappingStrategy.setType(Topic.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            beanToCsv = new StatefulBeanToCsvBuilder<Topic>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanToCsv.write(topics);

            System.out.println("Write CSV using BeanToCsv successfully!");
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }
    }
}
