package com.example.parcel.controller;
import com.example.parcel.dto.ParcelDTO;
import com.example.parcel.service.ParcelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping
    public ResponseEntity<List<ParcelDTO>> getAllParcels() {
        return ResponseEntity.ok(parcelService.getAllParcels());
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<ParcelDTO> getParcel(@PathVariable String trackingId) {
        return ResponseEntity.ok(parcelService.getParcelByTrackingId(trackingId));
    }

    @PostMapping
    public ResponseEntity<ParcelDTO> createParcel(@RequestBody ParcelDTO parcelDTO) {
        return ResponseEntity.ok(parcelService.createParcel(parcelDTO));
    }
}
