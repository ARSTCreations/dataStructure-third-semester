package com.tbqueuenasabah.tbqueuenasabah;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        //base
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10); gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(gridPane,1080,320);
        stage.setTitle("AntreanNasabahFX!");
        stage.setScene(scene);

        //instantiate
        Queue queue = new Queue();
        Text textAntrianNasabah = new Text("Antrian Nasabah");
        Text textTeller1 = new Text("TELLER 1");
        Text textMelayani1 = new Text("Sedang Melayani Nasabah -");
        Text textTeller2 = new Text("TELLER 2");
        Text textMelayani2 = new Text("Sedang Melayani Nasabah -");
        Button inButton = new Button("IN");
        Text textSilahkanKe = new Text("Nasabah nomor - silahkan ke Teller -");
        Text textAntrianTeller = new Text("Antrian Teller");
        Text textTeller11 = new Text("TELLER 1");
        Text textTeller22 = new Text("TELLER 2");
        Text textNomorAntrian1 = new Text("Nomor Antrian Saat Ini: ");
        Text textNomorAntrian2 = new Text("Nomor Antrian Saat Ini: ");
        Button next1 = new Button("NEXT");
        Button next2 = new Button("NEXT");
        Alert a = new Alert(Alert.AlertType.WARNING);

        //style
        style(textAntrianNasabah, textTeller1, textMelayani1, textTeller2, textMelayani2);
        textSilahkanKe.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        inButton.setPrefSize(100,100);
        next1.setPrefWidth(100);
        next2.setPrefWidth(100);
        style(textAntrianTeller, textTeller11, textTeller22, textNomorAntrian1, textNomorAntrian2);


        //GRIDs gp.add(objct,keKanan,keBawah)
        gridPane.add(textAntrianNasabah,0,0);
        gridPane.add(textTeller1,1,1);
        gridPane.add(textMelayani1,2,1);
        gridPane.add(textTeller2,1,2);
        gridPane.add(textMelayani2,2,2);
        gridPane.add(inButton,0,1,1,2);
        gridPane.add(textSilahkanKe,1,3,2,3);
        gridPane.add(textAntrianTeller,0,4);
        gridPane.add(textTeller11,0,5);
        gridPane.add(textNomorAntrian1,1,5);
        gridPane.add(next1,2,5);
        gridPane.add(textTeller22,0,6);
        gridPane.add(textNomorAntrian2,1,6);
        gridPane.add(next2,2,6);

        inButton.setOnAction(in->{
            if(queue.size() == 20) {
                a.setContentText("Jumlah antrian untuk saat ini penuh !");
                a.show();
            }else{
                if (queue.isGantian()){
                    queue.incrementAntrianKe();
                    queue.enqueue(queue.getAntrianKe());
                    textNomorAntrian1.setText("Nomor Antrian Saat Ini: "+queue.getAntrianKe());
                    queue.toggleGantian();
                    System.out.println("1: "+queue.getAntrianKe());
                }else {
                    queue.incrementAntrianKe();
                    queue.enqueue(queue.getAntrianKe());
                    textNomorAntrian2.setText("Nomor Antrian Saat Ini: "+queue.getAntrianKe());
                    queue.toggleGantian();
                    System.out.println("2: "+queue.getAntrianKe());
                }
            }
        });

        next1.setOnAction(n1-> {
            if(queue.size() == 0){
                a.setContentText("Untuk saat ini antrian masih kosong !");
                a.show();
            }else{
                textSilahkanKe.setText("Nasabah nomor " + queue.dequeue()+ " silahkan ke Teller 1");
                textMelayani1.setText("Sedang Melayani Nasabah Nomor "+queue.getAntrianNow());
            }
            if(queue.size() == 1){
                textNomorAntrian1.setText("Sedang Melayani Nasabah Nomor : - ");
                textNomorAntrian2.setText("Sedang Melayani Nasabah Nomor : - ");
            }
        });
        next2.setOnAction(n2-> {
            if(queue.size() == 0){
                a.setContentText("Untuk saat ini antrian masih kosong !");
                a.show();
            }else{
                textSilahkanKe.setText("Nasabah nomor " + queue.dequeue()+ " silahkan ke Teller 2");
                textMelayani2.setText("Sedang Melayani Nasabah Nomor "+queue.getAntrianNow());
            }
            if(queue.size() == 1){
                textNomorAntrian2.setText("Sedang Melayani Nasabah Nomor : - ");
                textNomorAntrian1.setText("Sedang Melayani Nasabah Nomor : - ");
            }
        });
        stage.show();
    }

    private void style(Text textAntrianNasabah, Text textTeller1, Text textMelayani1, Text textTeller2, Text textMelayani2) {
        textAntrianNasabah.setFont(Font.font("Tahoma", FontWeight.NORMAL,37));
        textTeller1.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        textMelayani1.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        textTeller2.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        textMelayani2.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
    }

    public static void main(String[] args) {
        launch();
    }
}