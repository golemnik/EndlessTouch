package com.golem.tech;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public record RequestContainer (HttpServletRequest req, HttpServletResponse resp) {

}
