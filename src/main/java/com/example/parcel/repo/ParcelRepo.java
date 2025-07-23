package com.example.parcel.repo;


import com.example.parcel.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepo extends JpaRepository<Parcel, String> {
}

