package com.example.demoMyBatis.dto.request;

import java.util.UUID;

public record UpdateCarRequest(String carName, String carTypeId, String carBrandId, int carYear) {
}
