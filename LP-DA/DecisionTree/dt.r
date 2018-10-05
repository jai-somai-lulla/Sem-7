library(rpart)
raw=read.csv('bd.csv')
t1=raw[,c(1,4,6,9)]

uq=quantile(t1$Duration)[2]
lq=quantile(t1$Duration)[4]

catagorize <- function(x,uq,lq) {
   if(x>uq){
    result="High"
   }else if(x>lq){
        result="Medium"
   }else{
        result="Low"
   }
   return (result)
}

t1$cd=sapply(t1$Duration,catagorize,uq=uq,lq=lq)
t1=t1[,c(2:5)]
index <- sample(1:nrow(t1),round(0.75*nrow(t1)))
train <- t1[index,]
test <- t1[-index,]
fit <- rpart(Member.type~Start.station.number+End.station.number+cd,method="class",data=train,control =rpart.control(minsplit =300,minbucket=100, cp=0))
ans=predict(fit,test,type="class")
tx=table(ans,test$Member.type)
accuracy_Test <- sum(diag(tx)) / sum(tx)

