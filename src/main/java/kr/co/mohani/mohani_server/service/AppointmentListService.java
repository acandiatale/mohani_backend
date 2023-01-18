package kr.co.mohani.mohani_server.service;

import kr.co.mohani.mohani_server.entity.Appointment;
import kr.co.mohani.mohani_server.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentListService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentList(String group_id, String date) {
        List<Appointment> appointment = appointmentRepository.findAllByGroupId(group_id);
        for(Appointment tmp : appointment) {
            log.info(tmp.getWritedTime().toString());
        }
        return appointment;
    }

    public String addAppointment(Appointment appointment) {
        Appointment saved = appointmentRepository.save(appointment);
        log.info(saved.getWritedTime().toString());
        return "";
    }

}
