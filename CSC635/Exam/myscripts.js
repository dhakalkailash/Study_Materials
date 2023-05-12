// <!-- Name : Kailash Dhakal
// Major : Master's in Computer Science
// Assignment CSC 635
// Description of the Assignment :
// write the Javascript to prompt the user to provide input of the container 
// Width, Height, depth, 
// Calculate the volume, surface area, he program then prints all values (width, height, depth, volume, surface area, length of edges, weight of water at 90° Celsius) using easy to read formatting (a table) as well as units (g, kg, mm/cm/m, mm^2 or cm^2 or m^2, mm^3 or cm^3 or m^3, etc) in the client area of your Web browser.
// Comments/documentation and formatting of the program/source code. Additionally, provide this assignment write-up, your name, and CSC concentration in the comments as well as in the browser's client area.
//  Format/round all calculations to two decimals (i.e., 12.34536 results in 12.35).
//  Format the output neatly using an external CSS file.
// Provide hyperlinks to your files like you did before (*.css, *.js, *.html → *.txt) -->


// <!-- Instruction to run the code:
// Please run the index.html file it will prompt to provide the input.
// After providing the inputs reult will be display in table format in webpage.  -->


		var width = parseFloat(prompt("Enter the width of the box in millimeters:"));
		var height = parseFloat(prompt("Enter the height of the box in millimeters:"));
		var depth = parseFloat(prompt("Enter the depth of the box in millimeters:"));

		var volume = (width * height * depth) / 1000000;
		var surfaceArea = 2 * (width * height + height * depth + depth * width) / 100;
		var lengthOfEdges = 4 * (width + height + depth);

		var waterWeight = volume * 1; // Assuming density of water at 90°C is 1 g/cm³

		document.write("<table>");
        document.write("<tr><td>Given Inputs</td><td>" + " Values </td></tr>");
		document.write("<tr><td>Width:</td><td>" + width.toFixed(2) + " mm</td></tr>");
		document.write("<tr><td>Height:</td><td>" + height.toFixed(2) + " mm</td></tr>");
		document.write("<tr><td>Depth:</td><td>" + depth.toFixed(2) + " mm</td></tr></br>");
        document.write("</table>");
        document.write("<table>");
        document.write("<tr><td>Result</td><td>" + " Values </td></tr></br>");
		document.write("<tr><td>Volume:</td><td>" + volume.toFixed(2) + " cm³</td></tr>");
		document.write("<tr><td>Surface Area:</td><td>" + surfaceArea.toFixed(2) + " cm²</td></tr>");
		document.write("<tr><td>Length of Edges:</td><td>" + lengthOfEdges.toFixed(2) + " mm</td></tr>");
		document.write("<tr><td>Weight of Water at 90°C:</td><td>" + waterWeight.toFixed(2) + " g</td></tr>");
		document.write("</table>");
	