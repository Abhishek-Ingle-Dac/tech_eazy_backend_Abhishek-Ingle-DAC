package com.example.parcel.service;
import com.example.parcel.dto.ParcelDTO;
import com.example.parcel.entity.Parcel;
import com.example.parcel.repo.ParcelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepo parcelRepo;

    public ParcelServiceImpl(ParcelRepo parcelRepo) {
        this.parcelRepo = parcelRepo;
    }

    @Override
    public List<ParcelDTO> getAllParcels() {
        return parcelRepo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParcelDTO getParcelByTrackingId(String trackingId) {
        Optional<Parcel> optional = parcelRepo.findById(trackingId);
        if (optional.isEmpty()) {
            throw new RuntimeException("Parcel with ID " + trackingId + " not found.");
        }
        return mapToDTO(optional.get());
    }

    @Override
    public ParcelDTO createParcel(ParcelDTO dto) {
        Parcel parcel = mapToEntity(dto);
        Parcel saved = parcelRepo.save(parcel);
        return mapToDTO(saved);
    }

    private ParcelDTO mapToDTO(Parcel parcel) {
        return new ParcelDTO(
                parcel.getTrackingId(),
                parcel.getSender(),
                parcel.getReceiver(),
                parcel.getOrigin(),
                parcel.getDestination(),
                parcel.getStatus()
        );
    }

    private Parcel mapToEntity(ParcelDTO dto) {
        return new Parcel(
                dto.getTrackingId(),
                dto.getSender(),
                dto.getReceiver(),
                dto.getOrigin(),
                dto.getDestination(),
                dto.getStatus()
        );
    }
}

