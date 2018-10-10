#print("Hello")
#library(caTools) 
library(e1071)
library(caret) 
dat = read.csv("diabetes.csv", header = TRUE)
#head(dat)
#names(dat)
#summary(dat)

#smp_size = floor(0.25*nrow(dat))
#print("Test Size smp_size")
#print(smp_size)

#sample = sample.split(dat,SplitRatio = 0.75) # splits the data in the ratio mentioned in SplitRatio. After splitting marks these rows as logical TRUE and the the remaining are marked as logical FALSE
#train1 =subset(dat,sample ==TRUE) # creates a training dataset named train1 with rows which are marked as TRUE
#test1=subset(dat, sample==FALSE)
#head(train1)

index <- sample(1:nrow(dat),round(0.75*nrow(dat)))
train1 <- dat[index,]
test1 <- dat[-index,]


catagorize <- function(x) {
   if(x==1){
    result="Positive"
   }  
   else{
     result="Negative"
   } 
   return (result)   
}

dat$Outcome=sapply(dat$Outcome,catagorize)

Naive_Bayes_Model <- naiveBayes(Outcome~., data=train1)
#Naive_Bayes_Model

NB_Predictions=predict(Naive_Bayes_Model,test1,"raw")
#NB_Predictions
highestprob=colnames(NB_Predictions)[apply(NB_Predictions,1,which.max)]
#apply(NB_Predictions, 1, which.is.max)
#test1$Outcome
#head(NB_Predictions)
#Confusion matrix to check accuracy
xtab=table(highestprob,test1$Outcome)
confusionMatrix(xtab)

