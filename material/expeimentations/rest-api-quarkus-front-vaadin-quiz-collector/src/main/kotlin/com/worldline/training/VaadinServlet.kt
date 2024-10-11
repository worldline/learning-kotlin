package com.worldline.training

import com.vaadin.quarkus.QuarkusVaadinServlet
import jakarta.servlet.annotation.WebServlet

@WebServlet(urlPatterns = ["/ui/*"], name = "VaadinServlet", asyncSupported = true)
class VaadinServlet : QuarkusVaadinServlet()