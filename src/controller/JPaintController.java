package controller;

import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> CopyCommand.copy());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand().execute());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand().execute());
        uiModule.addEvent(EventName.GROUP, () -> new GroupShapesCommand().execute());
        uiModule.addEvent(EventName.UNGROUP, () -> new UnGroupCommand().execute());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().execute());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().execute());
    }
}
