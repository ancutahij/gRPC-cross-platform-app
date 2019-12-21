
package controller;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import model.AgencyEmployee;
import model.Journey;
import model.Reservation;
import res.protocol.ProtosUtils;
import res.protocol.ReservationProtocol;
import res.protocol.ReservationServiceGrpc;

import java.net.URL;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class JourneysController implements Initializable {
    @FXML
    private TableView<Journey> allJourneysTable;
    @FXML
    private TableView<Journey> filteredJourneysTable;


    @FXML
    TableColumn<Journey, String> columnDestination;
    @FXML
    TableColumn<Journey, String> columnTransport;
    @FXML
    TableColumn<Journey, LocalTime> columnDepartureTime;
    @FXML
    TableColumn<Journey, Double> columnPrice;
    @FXML
    TableColumn<Journey, Integer> columnNoAvailableSeats;


    @FXML
    TableColumn<Journey, String> columnDestination1;
    @FXML
    TableColumn<Journey, String> columnTransport1;
    @FXML
    TableColumn<Journey, LocalTime> columnDepartureTime1;
    @FXML
    TableColumn<Journey, Double> columnPrice1;
    @FXML
    TableColumn<Journey, Integer> columnNoAvailableSeats1;

    @FXML
    private TextField txtSearchDestination;

    @FXML
    private TextField txtStartHour;

    @FXML
    private TextField txtEndHour;


    @FXML
    private TextField txtCustomerName;


    @FXML
    private TextField txtPhoneNumber;


    @FXML
    private TextField txtNoSeats;


    private ObservableList<Journey> model = FXCollections.observableArrayList();
    private ObservableList<Journey> filteredModel = FXCollections.observableArrayList();


    private ReservationServiceGrpc.ReservationServiceStub asyncServer;
    private ReservationServiceGrpc.ReservationServiceBlockingStub syncServer;

    private AgencyEmployee currentUser;


    public JourneysController(ReservationServiceGrpc.ReservationServiceStub asyncServer) {
        this.asyncServer = asyncServer;

    }
    public JourneysController() {
    }

    public void setAsyncServer(ReservationServiceGrpc.ReservationServiceStub s) {
        asyncServer = s;
        subscribe();

    }
    public void setSyncServer(ReservationServiceGrpc.ReservationServiceBlockingStub s){
        syncServer= s;
    }

    private void subscribe() {

        StreamObserver<ReservationProtocol.Notification> streamObserver = new StreamObserver<ReservationProtocol.Notification>() {
            @Override
            public void onNext(ReservationProtocol.Notification value) {
                res.protocol.ReservationProtocol.Journey protoJourney= value.getJourney();
                Journey journey = ProtosUtils.getModelJourney(protoJourney);
                List<Journey> list = new LinkedList<>();
                for( int i=0 ; i<model.size();i++)
                {
                    if (model.get(i).getID().equalsIgnoreCase(journey.getID()))
                        list.add(journey);
                    else
                        list.add(model.get(i));
                }

                filteredModel.setAll(list);
                model.setAll(list);

                initialize();
                updateTableViewLook(allJourneysTable);
                updateTableViewLook(filteredJourneysTable);
            }

            @Override
            public void onError(Throwable t) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        WindowsUtils.showErrorMessage(t.getMessage());
                    }
                });
            }

            @Override
            public void onCompleted() {

            }
        };
        ReservationProtocol.ReservationRequest request = ReservationProtocol.ReservationRequest
                .newBuilder()
                .setAgencyEmployee(ProtosUtils.getProtoAgencyEmployee(currentUser))
                .build();
        asyncServer.subscribe(request, streamObserver);
    }

    public void setCurrentUser(AgencyEmployee currentUser) {
        this.currentUser = currentUser;
    }

    @FXML
    public void initialize() {


        columnDestination.setCellValueFactory(new PropertyValueFactory<>("TouristiObjective"));
        columnTransport.setCellValueFactory(new PropertyValueFactory<>("TransportCompany"));
        columnDepartureTime.setCellValueFactory(new PropertyValueFactory<>("DepartureTime"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        columnNoAvailableSeats.setCellValueFactory(new PropertyValueFactory<>("NoAvailableSeats"));


        columnDestination1.setCellValueFactory(new PropertyValueFactory<>("TouristiObjective"));
        columnTransport1.setCellValueFactory(new PropertyValueFactory<>("TransportCompany"));
        columnDepartureTime1.setCellValueFactory(new PropertyValueFactory<>("DepartureTime"));
        columnPrice1.setCellValueFactory(new PropertyValueFactory<>("Price"));
        columnNoAvailableSeats1.setCellValueFactory(new PropertyValueFactory<>("NoAvailableSeats"));


        //setting models for Journey Tables
        allJourneysTable.setItems(model);
        filteredJourneysTable.setItems(filteredModel);

    }

    public void initContentTables( ObservableList<Journey> model,  ObservableList<Journey> filteredModel)
    {
        this.model= model;
        this.filteredModel = filteredModel;

        ReservationProtocol.ReservationRequest reservationRequest = ReservationProtocol
                .ReservationRequest.newBuilder()
                .setType(ReservationProtocol.ReservationRequest.Type.GETALLJOURNEYS)
                .build();


        ReservationProtocol.ReservationResponse response =syncServer.getJourneys(reservationRequest);
        if(response.getType()== ReservationProtocol.ReservationResponse.Type.OK)
        {
            List<Journey> list = ProtosUtils.getModelJourneysList(response.getJourneys());

            filteredModel.setAll(list);
            model.setAll(list);

            initialize();
            updateTableViewLook(allJourneysTable);
            updateTableViewLook(filteredJourneysTable);
        }
    }


        @FXML
    private void onActionBookButton(ActionEvent actionEvent) {
        if (txtCustomerName.getText().equals("") || txtPhoneNumber.getText().equals("") || txtNoSeats.getText().equals("")) {
            WindowsUtils.showErrorMessage("One or more empty fields");
        }
        else {

            String customerName = txtCustomerName.getText();
            String phoneNumber = txtPhoneNumber.getText();
            int noTickets = Integer.parseInt(txtNoSeats.getText());
            Journey journey = filteredJourneysTable.getSelectionModel().getSelectedItem();

            if (journey == null) {
                WindowsUtils.showErrorMessage("Please select a journey from the right table!");
            }

            if (journey.getNoAvailableSeats() <= 0) {
                WindowsUtils.showErrorMessage("Please select another journey. No available seats anymore!");
            }
            else {
                Reservation reservation = new Reservation("", customerName, phoneNumber, noTickets, journey);
                ReservationProtocol.ReservationRequest reservationRequest = ReservationProtocol.ReservationRequest.newBuilder()
                        .setType(ReservationProtocol.ReservationRequest.Type.SAVERESERVATION)
                        .setReservation(ProtosUtils.getProtoReservation(reservation))
                        .build();
                ReservationProtocol.ReservationResponse response = syncServer.saveReservation(reservationRequest);
                if ( response.getType()== ReservationProtocol.ReservationResponse.Type.OK)
                        WindowsUtils.showConfirmationMessage("Reservation was successfully booked!");
            }

        }
    }

        @FXML
    private void onActionSearchButton(ActionEvent actionEvent) {

            if (txtSearchDestination.getText().equals("") || txtEndHour.getText().equals("") || txtStartHour.getText().equals(""))
                WindowsUtils.showErrorMessage("One or more empty fields");
            else {
                String destination = txtSearchDestination.getText();
                String start = txtStartHour.getText();
                String end = txtEndHour.getText();

                ReservationProtocol.FilteredJourneyDTO filteredJourneyDTO = ReservationProtocol.FilteredJourneyDTO
                        .newBuilder()
                        .setDestination(destination)
                        .setStartTime(start)
                        .setEndTime(end)
                        .build();
                ReservationProtocol.ReservationRequest request = ReservationProtocol.ReservationRequest
                        .newBuilder()
                        .setType(ReservationProtocol.ReservationRequest.Type.GETFILTEREDJOURNEYS)
                        .setFilteredJourney(filteredJourneyDTO)
                        .build();

                ReservationProtocol.ReservationResponse response = syncServer.getFilteredJourneys(request);
                if ( response.getType() == ReservationProtocol.ReservationResponse.Type.OK)
                {
                    List<Journey> list = ProtosUtils.getModelJourneysList(response.getJourneys());
                    filteredModel.setAll(list);
                    clearFields();
                }
            }
        }

        @FXML
    public void onActionLogoutButton(ActionEvent actionEvent)
    {
        logout();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    }
    private CharSequence startWithZero(String text) {
        if (text.length() < 2)
            return "0" + text;
        return text;
    }

    private void clearFields() {
        txtEndHour.setText("");
        txtSearchDestination.setText("");
        txtStartHour.setText("");
        txtNoSeats.setText("");
        txtPhoneNumber.setText("");
        txtCustomerName.setText("");
    }



    public  void updateTableViewLook(TableView<Journey> table)
    {
        table.setRowFactory(row -> new TableRow<Journey>() {
            public void updateItem(Journey item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null)

                    if (item.getNoAvailableSeats() ==0 ) {
                        for (int i = 0; i < getChildren().size(); i++) {
                            ((Labeled) getChildren().get(i)).setStyle("-fx-text-fill: red");
                        }
                    } else

                        {
                            for (int i = 0; i < getChildren().size(); i++) {
                                ((Labeled) getChildren().get(i)).setStyle("-fx-text-fill: black");

                            }

                        }

            }
        });
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void logout() {
        ReservationProtocol.ReservationRequest request = ReservationProtocol.ReservationRequest
                .newBuilder()
                .setType(ReservationProtocol.ReservationRequest.Type.LOGOUT)
                .setAgencyEmployee(ProtosUtils.getProtoAgencyEmployee(currentUser))
                .build();
        ReservationProtocol.ReservationResponse response = syncServer.logout(request);
        if ( response.getType() == ReservationProtocol.ReservationResponse.Type.ERROR)
        {
            WindowsUtils.showErrorMessage(response.getErrorMessage());
        }

        currentUser = null;
    }


}


