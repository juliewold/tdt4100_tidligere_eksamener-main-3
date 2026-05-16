package com.twowheels.assembly.part6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import no.ntnu.tdt4100.twowheels.part6.IBikeStatusObserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BikeStatusTest {

    private BikeStatus bikeStatus;
    private IBikeStatusObserver observer;

    @BeforeEach
    public void setUp() {
        bikeStatus = new BikeStatus("BID1578", BikeStatus.BUILDING);
        observer = Mockito.mock(IBikeStatusObserver.class);
    }

    @Test
    public void testConstructorValidStatus() {
        BikeStatus bikeStatus = new BikeStatus("BID1578", BikeStatus.BUILDING);
        assertThat(bikeStatus.getBuildNumber()).isEqualTo("BID1578");
        assertThat(bikeStatus.getStatus()).isEqualTo(BikeStatus.BUILDING);
    }

    @Test
    public void testConstructorInvalidStatus() {
        assertThatThrownBy(() -> new BikeStatus("BID1578", "INVALID"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid build status");
    }

    @Test
    public void testConstructorNullBuildID() {
        assertThatThrownBy(() -> new BikeStatus(null, BikeStatus.BUILDING))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Build ID or status cannot be null");
    }

    @Test
    public void testConstructorNullStatus() {
        assertThatThrownBy(() -> new BikeStatus("BID1578", null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Build ID or status cannot be null");
    }

    @Test
    public void testSetStatusValid() {
        bikeStatus.addObserver(observer);
        bikeStatus.setStatus(BikeStatus.WAITING);
        assertThat(bikeStatus.getStatus()).isEqualTo(BikeStatus.WAITING);
        Mockito.verify(observer).updateBikeStatus("BID1578", BikeStatus.WAITING);
    }

    @Test
    public void testSetStatusInvalid() {
        assertThatThrownBy(() -> bikeStatus.setStatus("INVALID"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid build status");
    }

    @Test
    public void testAddObserver() {
        bikeStatus.addObserver(observer);
        bikeStatus.setStatus(BikeStatus.SHIPPED);
        Mockito.verify(observer).updateBikeStatus("BID1578", BikeStatus.SHIPPED);
    }

    @Test
    public void testRemoveObserver() {
        bikeStatus.addObserver(observer);
        bikeStatus.removeObserver(observer);
        bikeStatus.setStatus(BikeStatus.DELIVERED);
        Mockito.verify(observer, Mockito.never()).updateBikeStatus("BID1578", BikeStatus.DELIVERED);
    }

    @Test
    public void testAddMultipleObservers() {
        IBikeStatusObserver observer2 = Mockito.mock(IBikeStatusObserver.class);
        bikeStatus.addObserver(observer);
        bikeStatus.addObserver(observer2);
        bikeStatus.setStatus(BikeStatus.SHIPPED);
        Mockito.verify(observer).updateBikeStatus("BID1578", BikeStatus.SHIPPED);
        Mockito.verify(observer2).updateBikeStatus("BID1578", BikeStatus.SHIPPED);
    }

    @Test
    public void testRemoveMultipleObservers() {
        IBikeStatusObserver observer2 = Mockito.mock(IBikeStatusObserver.class);
        bikeStatus.addObserver(observer);
        bikeStatus.addObserver(observer2);
        bikeStatus.removeObserver(observer);
        bikeStatus.setStatus(BikeStatus.DELIVERED);
        Mockito.verify(observer, Mockito.never()).updateBikeStatus("BID1578", BikeStatus.DELIVERED);
        Mockito.verify(observer2).updateBikeStatus("BID1578", BikeStatus.DELIVERED);
    }
}