#myString <- "Hello, World!"
#print (myString)
#"dqweqwe"

#data <- read.csv("iris.csv")
#print(data)
#print(is.data.frame(data))
#print(ncol(data))
#print(nrow(data))

#find value of max data $ attribute
#print(max(data$Sepal.Length))

#get tuple
#retval <- subset(data, Sepal.Length == max(Sepal.Length))
#print(retval)

# Give the chart file a name.
png(file = "boxplot.png")

# Plot the chart.
boxplot(Sepal.Length ~ Species, data = data, xlab = "Species",
   ylab = "Sepal Length", main = "Length Data")

# Save the file.
dev.off()
