package org.israelgda.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.israelgda.dtos.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static ByteArrayInputStream opportunityToCSV(List<OpportunityDTO> opportunities) {
        final CSVFormat format = CSVFormat.DEFAULT.withHeader(
                "ID Proposta",
                "Cliente",
                "Preço por Tonelada",
                "Melhor cotação de Moeda"
        );

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);

            opportunities.forEach(it -> {
                List<String> data = Arrays.asList(
                        String.valueOf(it.proposalId),
                        it.customer,
                        String.valueOf(it.priceTonne),
                        String.valueOf(it.lastDollarQuotation)

                );

                try {
                    csvPrinter.printRecord(data);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());

        } catch (final RuntimeException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
