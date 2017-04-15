# Create layers
layerA = new Layer
	width: 150
	height: 150
	x: Align.center(-90)
	y: Align.center
	backgroundColor: "#AAEEFF"
	borderRadius: 10

layerB = new Layer
	width: 150
	height: 150
	x: Align.center(90)
	y: Align.center
	backgroundColor: "#00AAFF"
	borderRadius: 75

# Add states
layerA.states.rotated =
	rotation: 180

layerB.states.rotated =
	rotationY: 180

# Animate states on click
layerA.onClick ->
	layerA.animate layerA.states.next()
	
layerB.onClick ->
	layerB.animate layerB.states.next()
