//package ui;
//
//import domain.Participare;
//import service.ServiceGeneral;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
////sunt mai multe layout - border layout (componente de n, s, e, v) / grid layout / flow layout, etc
////border layut pt lista si in partea de jos o alta componenta in sud. Aceasta sa aibe tot un layout border,
//// si in//sud butonul . Grid layout pentru casutele de input
//public class GUI extends JFrame {
//    private ServiceGeneral service;
//    private JList afisareEvenimente = new JList();
//
//    //declaram ceea ce inta in ComponentaMare
//    private JButton butonAdauga = new JButton("Adauga");
//    private JButton butonSterge = new JButton("Sterge");
//
//    private JTextField textID = new JTextField();
//    private JTextField textTitlu = new JTextField();
//    private JTextField textLocatie = new JTextField();
//    private JTextField textData = new JTextField();
//    private JTextField textNrPersoane = new JTextField();
//    private JTextField textLink = new JTextField();
//
//    //constructor
//    public GUI(ServiceGeneral service) {
//        this.service = service;
//        this.initializareGUI();
//        this.populeazaLista();
//        adaugaHandler();
//     //   this.stergeDinLista();
//    }
//
//    //clasa de tip jframe /
//    public void initializareGUI() {
//        this.setLayout(new BorderLayout());
//        //daca nu pun size apare doar o fereastra micuta.
//        this.setSize(new Dimension(400, 400));
//        this.add(this.afisareEvenimente, BorderLayout.CENTER);
//
//        //pentru o componenta noua se foloseste jpanel
//        JPanel componentaMare = new JPanel();
//        componentaMare.setLayout(new BorderLayout());
//        componentaMare.add(this.butonAdauga, BorderLayout.SOUTH);
//        componentaMare.add(this.butonSterge, BorderLayout.NORTH);
//        //adaug componenta la fereastra
//        this.add(componentaMare, BorderLayout.SOUTH);
//
//        //componenta cu test fielduri si layout cu grid
//        JPanel componentaTextFields = new JPanel();
//        componentaTextFields.setLayout(new GridLayout(6, 2));
//
//
//        //creare de labeluri
//        JLabel idLabel = new JLabel("ID");
//        JLabel tituluLabel = new JLabel("Titlu");
//        JLabel locatieLabel = new JLabel("Locatie");
//        JLabel dataLabel = new JLabel("DAta");
//        JLabel nrPersLabel = new JLabel("Numar pers");
//        JLabel linkLabel = new JLabel("Link");
//
//        //adaug labeluri la comp cu tetxt field
//        componentaTextFields.add(idLabel);
//        componentaTextFields.add(this.textID);
//        componentaTextFields.add(tituluLabel);
//        componentaTextFields.add(this.textTitlu);
//        componentaTextFields.add(locatieLabel);
//        componentaTextFields.add(this.textLocatie);
//        componentaTextFields.add(dataLabel);
//        componentaTextFields.add(this.textData);
//        componentaTextFields.add(nrPersLabel);
//        componentaTextFields.add(this.textNrPersoane);
//        componentaTextFields.add(linkLabel);
//        componentaTextFields.add(this.textLink);
//
//        //adaug totul la componenta mare de input
//        componentaMare.add(componentaTextFields, BorderLayout.CENTER);
//
//        this.setVisible(true);
//        //ca sa inchida aplicatia
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    public void populeazaLista() {
//        DefaultListModel<String> listModel = new DefaultListModel<>();
//        for (Participare e : this.service.getAll()) {
//            listModel.addElement(e.toString());
//            this.afisareEvenimente.setModel(listModel);
//        }
//    }
//
//  //  public void stergeDinLista (){     }
//
//    //event handler - daca am apasat butonul ce sa se intample
//    public void adaugaHandler() {
//        this.butonAdauga.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int id = Integer.parseInt(textID.getText());
//                String titlu = textTitlu.getText();
//                String locatie = textTitlu.getText();
//                String data = textData.getText();
//                int nrPers = Integer.parseInt(textNrPersoane.getText());
//                String link = textLink.getText();
//
//                try {
//                    service.adaugaEveniment(id, titlu, locatie, data, nrPers, link);
//                } catch (Exception ie) {
//                    ie.printStackTrace();
//                }
//                //fara this pentru ca sunt in action listner
//                populeazaLista();
//
//                //daca vreau ca dupa ce am scris sa se stearga
//                textTitlu.setText("");
//                textLocatie.setText("");
//                textData.setText("");
//                textNrPersoane.setText("");
//                textLink.setText("");
//            }
//        });
//    }
//
//}
