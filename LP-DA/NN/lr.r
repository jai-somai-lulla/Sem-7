########Linear Regression#####

set.seed(500)
library(MASS)
data <- Boston
#head(data)
#apply(data,2,function(x) sum(is.na(x)))


index <- sample(1:nrow(data),round(0.75*nrow(data)))
train <- data[index,]
test <- data[-index,]
lm.fit <- glm(medv~., data=train)
summary(lm.fit)
pr.lm <- predict(lm.fit,test)
MSE.lm <- sum((pr.lm - test$medv)^2)/nrow(test)
