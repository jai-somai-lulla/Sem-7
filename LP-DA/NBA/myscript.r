#print("Hello")
library(caTools) 
library(e1071)
dat = read.csv("mydata.csv", header = TRUE)
head(dat)
#names(dat)
#summary(dat)

#smp_size = floor(0.25*nrow(dat))
#print("Test Size smp_size")
#print(smp_size)

sample = sample.split(dat,SplitRatio = 0.75) # splits the data in the ratio mentioned in SplitRatio. After splitting marks these rows as logical TRUE and the the remaining are marked as logical FALSE
train1 =subset(dat,sample ==TRUE) # creates a training dataset named train1 with rows which are marked as TRUE
test1=subset(dat, sample==FALSE)
#head(train1)

Naive_Bayes_Model <- naiveBayes(Status~., data=train1)
Naive_Bayes_Model

NB_Predictions=predict(Naive_Bayes_Model,test1)
#Confusion matrix to check accuracy
table(NB_Predictions,test1$Status)

