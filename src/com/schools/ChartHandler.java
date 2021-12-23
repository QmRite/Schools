package com.schools;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ChartHandler {

    public static CategoryDataset createDatasetFromHashMap(HashMap<String, Float> map)
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String key : map.keySet()) {
            dataset.addValue(map.get(key), (Integer)10, key);
        }

        return dataset;
    }

    public static JFreeChart createChart(CategoryDataset dataset) throws IOException
    {
        JFreeChart chart = ChartFactory.createBarChart(
                "Среднее количество студентов в 10 странах",
                null,
                "Студенты",
                dataset);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.removeLegend();

        ChartUtilities.saveChartAsPNG(new File("C:\\Users\\QmRite\\IdeaProjects\\Schools\\histogram.png"), chart, 1100, 400);

        return chart;
    }
}
