package com.example.demoMyBatis.dto.request;

import java.util.UUID;

public record CreateCarRequest(String id, String carName, String carTypeId, String carBrandId, int carYear) {
}
