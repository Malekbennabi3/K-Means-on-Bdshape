import javax.swing.*;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



//For more information about the graphic representations check JFreeChart Github's repository

public class Hist {

    //Histogram of distance
    public static void Histo_dist(String methode, String y, double[] dist_mi, double[] dist_euc, double[] dist_ma) {


        JFrame frame = new JFrame("Methode " + methode);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocation(400,400);


        // Créer un jeu de données (dataset)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < dist_ma.length; i++) {
            dataset.addValue(dist_mi[i], "Minkowski", "i° " + (i + 1));
            dataset.addValue(dist_euc[i], "Eucidienne", "i° " + (i + 1));
            dataset.addValue(dist_ma[i], "Manhatten", "i° " + (i + 1));
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Histogram " + methode,
                "iterations",
                "" + y,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Personnaliser les couleurs et le fond de l'histogramme
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Couleurs des barres (Category 1, Category 2, Category 3)
        plot.getRenderer().setSeriesPaint(0, new Color(0xffa556)); // Couleur de Category 1
        plot.getRenderer().setSeriesPaint(1, new Color(0x6bbd6b)); // Couleur de Category 2
        plot.getRenderer().setSeriesPaint(2, new Color(0xe36968)); // Couleur de Category 3

        // Couleur de fond du graphique
        plot.setBackgroundPaint(new Color(0xDCA5A5));

        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        final double spacing = 0.1; // Réglez cet espacement selon vos besoins (par défaut: 0.2)
        renderer.setItemMargin(spacing);
        renderer.setDrawBarOutline(false); // Désactiver les contours des barres
        renderer.setShadowVisible(false); // Désactiver les ombres (effet 3D)


        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setVisible(true);
    }

    //Histogram of features
    public static void Histo_car(String dist, String y, double[] e34, double[] gfd, double[] sa, double[] f0) {

        JFrame frame = new JFrame("Distance "+dist);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocation(0,0);

        // Créer un jeu de données (dataset)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < e34.length; i++) {
            dataset.addValue(e34[i], "E34", "i° " + (i + 1));
            dataset.addValue(gfd[i], "GFD", "i° " + (i + 1));
            dataset.addValue(sa[i], "SA", "i° " + (i + 1));
            dataset.addValue(f0[i], "F0", "i° " + (i + 1));

        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Histogram of the 4 features",
                "iterations",
                "" + y,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Personnaliser les couleurs et le fond de l'histogramme
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Couleurs des barres (Category 1, Category 2, Category 3)
        plot.getRenderer().setSeriesPaint(0, new Color(0xffa556)); // Couleur de Category 1
        plot.getRenderer().setSeriesPaint(1, new Color(0x6bbd6b)); // Couleur de Category 2
        plot.getRenderer().setSeriesPaint(2, new Color(0xe36968)); // Couleur de Category 3
        plot.getRenderer().setSeriesPaint(3, new Color(0x61B0FF)); // Couleur de Category 4


        // Couleur de fond du graphique
        plot.setBackgroundPaint(new Color(0xADADAD));

        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        final double spacing = 0.1;
        renderer.setItemMargin(spacing);
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);


        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setVisible(true);
    }

    //Histogram of feature's precision
    public static void Histo_prec(String dist, String y, double[] p_e34, double[] p_gfd, double[] p_sa, double[] p_f0) {

        JFrame frame = new JFrame("Distance "+dist);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocation(0,420);


        // Créer un jeu de données (dataset)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < p_e34.length; i++) {
            dataset.addValue(p_e34[i], "E34", "i° " + (i + 1));
            dataset.addValue(p_gfd[i], "GFD", "i° " + (i + 1));
            dataset.addValue(p_sa[i], "SA", "i° " + (i + 1));
            dataset.addValue(p_f0[i], "F0", "i° " + (i + 1));

        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Histogram of the 4 features",
                "iterations",
                "" + y,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Personnaliser les couleurs et le fond de l'histogramme
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Couleurs des barres (Category 1, Category 2, Category 3)
        plot.getRenderer().setSeriesPaint(0, new Color(0xffa556)); // Couleur de Category 1
        plot.getRenderer().setSeriesPaint(1, new Color(0x6bbd6b)); // Couleur de Category 2
        plot.getRenderer().setSeriesPaint(2, new Color(0xFF0808)); // Couleur de Category 3
        plot.getRenderer().setSeriesPaint(3, new Color(0x61B0FF)); // Couleur de Category 4


        // Couleur de fond du graphique
        plot.setBackgroundPaint(new Color(0xE8E8DC));
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        final double spacing = 0.1; // Réglez cet espacement selon vos besoins (par défaut: 0.2)
        renderer.setItemMargin(spacing);
        renderer.setDrawBarOutline(false); // Désactiver les contours des barres
        renderer.setShadowVisible(false); // Désactiver les ombres (effet 3D)


        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setVisible(true);
    }

    //Tracer un histogramme entre le Rappel de chaque caracteristique
    public static void Histo_rapp(String dist, String y, double[] p_e34, double[] p_gfd, double[] p_sa, double[] p_f0) {

        JFrame frame = new JFrame("Distance "+dist);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocation(930,420);


        // Créer un jeu de données (dataset)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < p_e34.length; i++) {
            dataset.addValue(p_e34[i], "E34", "i° " + (i + 1));
            dataset.addValue(p_gfd[i], "GFD", "i° " + (i + 1));
            dataset.addValue(p_sa[i], "SA", "i° " + (i + 1));
            dataset.addValue(p_f0[i], "F0", "i° " + (i + 1));

        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Histogram of the 4 features",
                "iterations",
                "" + y,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Personnaliser les couleurs et le fond de l'histogramme
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Couleurs des barres (Category 1, Category 2, Category 3)
        plot.getRenderer().setSeriesPaint(0, new Color(0xffa556)); // Couleur de Category 1
        plot.getRenderer().setSeriesPaint(1, new Color(0x6bbd6b)); // Couleur de Category 2
        plot.getRenderer().setSeriesPaint(2, new Color(0xFF0808)); // Couleur de Category 3
        plot.getRenderer().setSeriesPaint(3, new Color(0x61B0FF)); // Couleur de Category 4


        // Couleur de fond du graphique
        plot.setBackgroundPaint(new Color(0xADADAD));

        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        final double spacing = 0.1; // Réglez cet espacement selon vos besoins (par défaut: 0.2)
        renderer.setItemMargin(spacing);
        renderer.setDrawBarOutline(false); // Désactiver les contours des barres
        renderer.setShadowVisible(false); // Désactiver les ombres (effet 3D)


        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setVisible(true);
    }

    //Tracer une courbe des vrais positifs
    public static void courb_pos(String dist, String y, double[] po_e34, double[] po_gfd, double[] po_sa, double[] po_f0){
        JFrame frame = new JFrame("Distance "+dist);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocation(930,0);


        // Création des séries de données pour chaque courbe
        XYSeries series1 = createSeries(po_e34, "E34");
        XYSeries series2 = createSeries(po_gfd, "GFD");
        XYSeries series3 = createSeries(po_sa, "SA");
        XYSeries series4 = createSeries(po_f0, "F0");

        // Création des collections de séries
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);

        // Création du graphique à partir des séries de données
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Curve of the true Positives",
                "Iterations ",
                "Positives ",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setVisible(true);
    }

    // method to create dataset from an array
    private static XYSeries createSeries(double[] data, String seriesName) {
        XYSeries series = new XYSeries(seriesName);
        for (int i = 0; i < data.length; i++) {
            series.add(i + 1, data[i]); // add the data to the serie
        }
        return series;
    }


}






