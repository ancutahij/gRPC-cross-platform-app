package controller;

import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.AgencyEmployee;
import model.Journey;
import res.protocol.ProtosUtils;
import res.protocol.ReservationProtocol;
import res.protocol.ReservationServiceGrpc;

import java.util.List;
import java.util.stream.Collectors;


public class LoginController {
    private ReservationServiceGrpc.ReservationServiceStub asyncServer;
    private ReservationServiceGrpc.ReservationServiceBlockingStub syncServer;
    private JourneysController journeysController;
    private AgencyEmployee currentAgencyEmployee ;
    Parent mainChatParent;

    private ObservableList<Journey> model = FXCollections.observableArrayList();
    private ObservableList<Journey> filteredModel = FXCollections.observableArrayList();


    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;


    public void setAsyncServer(ReservationServiceGrpc.ReservationServiceStub s){

        asyncServer =s;
    }
    public void setParent(Parent p){

        mainChatParent=p;
    }

    public void setSyncServer(ReservationServiceGrpc.ReservationServiceBlockingStub s){
        syncServer= s;
    }

    @FXML
    public void initialize(){
        txtLogin.setText("popMaria");
        txtPassword.setText("1234");
    }
    @FXML
    private void onActionResetButton(ActionEvent actionEvent) {
        txtLogin.setText("");
        txtPassword.setText("");
    }

    public void setJourneysControllerController(JourneysController controller) {
        this.journeysController = controller;
    }

    @FXML
    private void onActionLoginButton(ActionEvent actionEvent)
    {

        String username = txtLogin.getText();
        String password = txtPassword.getText();
        currentAgencyEmployee = new AgencyEmployee("", username, password);

        res.protocol.ReservationProtocol.AgencyEmployee agencyEmployee =
                res.protocol.ReservationProtocol.AgencyEmployee.newBuilder().setId("").setUsername(username).setPassword(password).build();

        ReservationProtocol.ReservationRequest reservationRequest = ReservationProtocol.ReservationRequest.newBuilder().setType(ReservationProtocol.ReservationRequest.Type.LOGIN).setAgencyEmployee(agencyEmployee).build();
        ReservationProtocol.ReservationResponse response  = syncServer.login(reservationRequest);
        if (response.getType()== ReservationProtocol.ReservationResponse.Type.ERROR)
        {
            WindowsUtils.showErrorMessage(response.getErrorMessage());
        }
        else
        {
            journeysController.setCurrentUser(currentAgencyEmployee);
            journeysController.setSyncServer(syncServer);
            journeysController.setAsyncServer(asyncServer);
            Stage stage = new Stage();
            stage.setTitle(String.format("Agency Employee: %s", username));
            stage.setScene(new Scene(mainChatParent));
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {

                    journeysController.logout();
                    System.exit(0);
                }
            });
            stage.show();
            journeysController.initContentTables(model, filteredModel);

            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        }
    }

}



