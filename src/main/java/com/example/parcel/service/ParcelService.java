package com.example.parcel.service;
import com.example.parcel.dto.ParcelDTO;
import java.util.List;

public interface ParcelService {
	List<ParcelDTO> getAllParcels();
	ParcelDTO getParcelByTrackingId(String trackingId);
	ParcelDTO createParcel(ParcelDTO parcelDTO);
}

