package kr.co.mohani.mohani_server.controller;

import kr.co.mohani.mohani_server.entity.Appointment;
import kr.co.mohani.mohani_server.entity.UserGroup;
import kr.co.mohani.mohani_server.service.AppointmentListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class AppointmentController {
    private final AppointmentListService appointmentService;

    @Autowired
    public AppointmentController(AppointmentListService appointmentService) {
        this.appointmentService = appointmentService;

    }

    @GetMapping(value = "/getAppointmentWithRange", produces = "application/json; charset=UTF-8")
    public List<Appointment> getMonthAppointment(@RequestParam String groupId, @RequestParam String start, @RequestParam String end) {
        return appointmentService.getAppointmentWithRange(groupId, start, end);
    }

    @PostMapping(value = "/addAppointment", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment) {
        log.info("AppointmentController : request Appointment = groupId : {}, writedTime : {}",
                appointment.getGroupId(), appointment.getWritedTime());
        ResponseEntity<?> result= appointmentService.addAppointment(appointment);
        log.info("AppointmentController completed, result = {}", result);
        return result;
    }

}
