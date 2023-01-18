package kr.co.mohani.mohani_server.controller;

import kr.co.mohani.mohani_server.entity.Appointment;
import kr.co.mohani.mohani_server.service.AppointmentListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getAppointment")
    public List<Appointment> getAppointment(@RequestParam String id, @RequestParam String date) {
        log.info("AppointmentController params : id = {}, date= {}", id, date);
        return appointmentService.getAppointmentList(id, date);
    }

    @PostMapping("/addAppointment")
    public String addAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
        log.info("request body : groupId{}", appointment.getGroupId());
        return "test";
    }



}
