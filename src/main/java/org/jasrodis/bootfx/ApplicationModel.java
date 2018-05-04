package org.jasrodis.bootfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ApplicationModel {

    private static class SingletonHolder {
        static final ApplicationModel INSTANCE = new ApplicationModel();
    }

    public static ApplicationModel getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public enum State {
        // Define application states
        STOPPED,
        STARTED,
        RUNNING,
        CLOSING,
    }

    private ObjectProperty<State> appState;
    
    private ApplicationModel() {
        appState = new SimpleObjectProperty<>(this, "appState", null);
    }

    public final State getApplicationState() {
        return appState.get();
    }

    public final void setApplicationState(State state) {
        appState.set(state);
    }

    public final ObjectProperty<State> getApplicationStateProperty() {
        return appState;
    }

}
