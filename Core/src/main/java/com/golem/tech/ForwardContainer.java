package com.golem.tech;

import jakarta.servlet.ServletContext;

public record ForwardContainer (ServletContext servletContext, RequestContainer requestContainer) {
}
