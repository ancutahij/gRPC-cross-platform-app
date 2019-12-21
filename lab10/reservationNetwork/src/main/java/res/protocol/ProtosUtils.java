package res.protocol;

import model.Journey;
import model.Reservation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;


public class ProtosUtils {
    public static model.Journey getModelJourney(res.protocol.ReservationProtocol.Journey protoJourney)
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String[] splits  = protoJourney.getDepartureTime().split(":");
        // convert 0:12 to 00:12
        String time=protoJourney.getDepartureTime();
        if (splits[0].length()<2)
        {
            time = "0"+time;
        }
        if ( splits[0].length() >2)
        {
            time ="00:00";
        }
        return new Journey(protoJourney.getId(),protoJourney.getTouristicObjective(),
                protoJourney.getTransportCompany(),
                LocalTime.parse(time , formatter),
                protoJourney.getPrice(), protoJourney.getNoAvailableSeats());
    }


    public static res.protocol.ReservationProtocol.AgencyEmployee getProtoAgencyEmployee(model.AgencyEmployee agencyEmployee)
    {
        return res.protocol.ReservationProtocol.AgencyEmployee.newBuilder()
                .setId(agencyEmployee.getID())
                .setUsername(agencyEmployee.getUsername())
                .setPassword(agencyEmployee.getPassword())
                .build();
    }


    public static res.protocol.ReservationProtocol.Journey getProtoJourney ( Journey journey)
    {
        return res.protocol.ReservationProtocol.Journey
                .newBuilder()
                .setTransportCompany(journey.getTransportCompany())
                .setTouristicObjective(journey.getTouristiObjective())
                .setNoAvailableSeats(journey.getNoAvailableSeats())
                .setPrice(journey.getPrice())
//                .setDepartureTime(null)
                .setId(journey.getID())
                .build();

    }
    public static res.protocol.ReservationProtocol.Reservation getProtoReservation(Reservation ress)
    {
        return res.protocol.ReservationProtocol.Reservation
                .newBuilder()
                .setCustomerName(ress.getCustomerName())
                .setId(ress.getID())
                .setPhoneNumber(ress.getPhoneNumber())
                .setNoTickets(ress.getNoTickets())
                .setJourney(ProtosUtils.getProtoJourney(ress.getJourney()))
                .build();
    }

    public static List<Journey> getModelJourneysList(ReservationProtocol.Journeys protoJourneys)
    {
        List<Journey> list = new LinkedList<>();
        for(int i =0 ;i < protoJourneys.getJourneyCount() ; i++)
        {
            list.add(ProtosUtils.getModelJourney(protoJourneys.getJourney(i)));
        }
        return list;
    }
}
