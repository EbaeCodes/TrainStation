package drawingTool_00.graphicState;

import drawingTool_00.Scene;

public class TrainStationState extends State {

    private static TrainStationState instance;

    private TrainStationState(Scene context) {
	this.context = context;
	trainStation = this;

    }

    public static TrainStationState getInstance(Scene context) {
	if (instance == null) {
	    instance = new TrainStationState(context);
	}
	return instance;
    }

    @Override
    public State drawTrain() {
	context.clear();
	context.showTrains();
	return TrainState.getInstance(context);
    }

    @Override
    public State drawTrainStation() {
	context.clear();
	context.showTrainStation();
	return this;
    }

    @Override
    public State drawScene() {
	context.clear();
	context.showScene();
	return SceneState.getInstance(context);
    }
}
