package com.bytebadger.assembly.part6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import no.ntnu.tdt4100.bytebadger.part6.IBuildStatusObserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuildStatusTest {

    private BuildStatus buildStatus;
    private IBuildStatusObserver observer;

    @BeforeEach
    public void setUp() {
        buildStatus = new BuildStatus("BID1578", BuildStatus.BUILDING);
        observer = Mockito.mock(IBuildStatusObserver.class);
    }

    @Test
    public void testConstructorValidStatus() {
        BuildStatus buildStatus = new BuildStatus("BID1578", BuildStatus.BUILDING);
        assertThat(buildStatus.getBuildNumber()).isEqualTo("BID1578");
        assertThat(buildStatus.getStatus()).isEqualTo(BuildStatus.BUILDING);
    }

    @Test
    public void testConstructorInvalidStatus() {
        assertThatThrownBy(() -> new BuildStatus("BID1578", "INVALID"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid build status");
    }

    @Test
    public void testConstructorNullBuildID() {
        assertThatThrownBy(() -> new BuildStatus(null, BuildStatus.BUILDING))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Build ID or status cannot be null");
    }

    @Test
    public void testConstructorNullStatus() {
        assertThatThrownBy(() -> new BuildStatus("BID1578", null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Build ID or status cannot be null");
    }

    @Test
    public void testSetStatusValid() {
        buildStatus.addObserver(observer);
        buildStatus.setStatus(BuildStatus.WAITING);
        assertThat(buildStatus.getStatus()).isEqualTo(BuildStatus.WAITING);
        Mockito.verify(observer).updateBuildStatus("BID1578", BuildStatus.WAITING);
    }

    @Test
    public void testSetStatusInvalid() {
        assertThatThrownBy(() -> buildStatus.setStatus("INVALID"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid build status");
    }

    @Test
    public void testAddObserver() {
        buildStatus.addObserver(observer);
        buildStatus.setStatus(BuildStatus.SHIPPED);
        Mockito.verify(observer).updateBuildStatus("BID1578", BuildStatus.SHIPPED);
    }

    @Test
    public void testRemoveObserver() {
        buildStatus.addObserver(observer);
        buildStatus.removeObserver(observer);
        buildStatus.setStatus(BuildStatus.DELIVERED);
        Mockito.verify(observer, Mockito.never()).updateBuildStatus("BID1578", BuildStatus.DELIVERED);
    }

    @Test
    public void testAddMultipleObservers() {
        IBuildStatusObserver observer2 = Mockito.mock(IBuildStatusObserver.class);
        buildStatus.addObserver(observer);
        buildStatus.addObserver(observer2);
        buildStatus.setStatus(BuildStatus.SHIPPED);
        Mockito.verify(observer).updateBuildStatus("BID1578", BuildStatus.SHIPPED);
        Mockito.verify(observer2).updateBuildStatus("BID1578", BuildStatus.SHIPPED);
    }

    @Test
    public void testRemoveMultipleObservers() {
        IBuildStatusObserver observer2 = Mockito.mock(IBuildStatusObserver.class);
        buildStatus.addObserver(observer);
        buildStatus.addObserver(observer2);
        buildStatus.removeObserver(observer);
        buildStatus.setStatus(BuildStatus.DELIVERED);
        Mockito.verify(observer, Mockito.never()).updateBuildStatus("BID1578", BuildStatus.DELIVERED);
        Mockito.verify(observer2).updateBuildStatus("BID1578", BuildStatus.DELIVERED);
    }
}