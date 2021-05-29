package io.susimsek.kafka.demo.controller.web;


import io.swagger.v3.oas.annotations.Hidden;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Hidden // Hide all endpoints
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Controller
public class WebController {


   @GetMapping("/api")
   public String index() {
      return "redirect:/api/swagger-ui.html";
   }

}