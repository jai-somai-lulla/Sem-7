#LOAD
set.seed(500)
library(MASS)
library(neuralnet)

data <- Boston

#Random indices of n rows choosing 0.75 of those n rows
index <- sample(1:nrow(data),round(0.75*nrow(data)))

#get max and min
maxs <- apply(data, 2, max) 
mins <- apply(data, 2, min)


#get new min-max scaled data frame
scaled <- as.data.frame(scale(data, center = mins, scale = maxs - mins))
#Training and test set
train_ <- scaled[index,]
test_ <- scaled[-index,]

n <- names(train_)
f <- as.formula(paste("medv ~", paste(n[!n %in% "medv"], collapse = " + ")))
#make model
nn <- neuralnet(f,data=train_,hidden=c(5,3),linear.output=T)

#Draw nn and show weights and biases
#plot(nn)
#nn$result.matrix

#Run test test
pr.nn <- compute(nn,test_[,1:13])

#Scale back result and test set result
pr.nn_ <- pr.nn$net.result*(max(data$medv)-min(data$medv))+min(data$medv)
test.r <- (test_$medv)*(max(data$medv)-min(data$medv))+min(data$medv)

#add the square of difference of elements in vectors and divide ny number of elements
MSE.nn <- sum((test.r - pr.nn_)^2)/nrow(test_)


#Put them side by side
#results <- data.frame(actual =test.r, prediction = pr.nn_)
  
