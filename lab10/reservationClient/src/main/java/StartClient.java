import controller.JourneysController;
import controller.LoginController;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import res.protocol.ReservationServiceGrpc;

public class StartClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext(true).build();
        ReservationServiceGrpc.ReservationServiceStub asyncServerStub = ReservationServiceGrpc.newStub(channel);
        ReservationServiceGrpc.ReservationServiceBlockingStub syncServiceStub =ReservationServiceGrpc.newBlockingStub(channel);

        System.out.println("Start client");

        FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader().getResource("login.fxml"));
        Parent root=loader.load();

        LoginController ctrl =loader.getController();
        ctrl.setAsyncServer(asyncServerStub);
        ctrl.setSyncServer(syncServiceStub);

        FXMLLoader journeys = new FXMLLoader(  getClass().getClassLoader().getResource("journeys.fxml"));
        Parent croot=journeys.load();

        JourneysController journeysCtrl =
                journeys.getController();
        //journeysCtrl.setAsyncServer(asyncServerStub);

        ctrl.setJourneysControllerController(journeysCtrl);
        ctrl.setParent(croot);


        primaryStage.setTitle("MPP Reservation gRPC");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}

