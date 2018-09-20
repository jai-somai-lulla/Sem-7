
                 
db.movierating.aggregate([
                     { $match: { rating: { $lt: 5 } } },
                     { $group: { _id: "$movieid", total: { $sum: "$rating" } } },
                     { $sort: { total: -1 } }
                   ])
                   
 db.movierating.aggregate([                      { $match: { rating: { $lt: 5 } } },                      { $group: { _id: "$movieid", total: { $avg: "$rating" } } },                      { $sort: { total: -1 } }                    ])


db.movierating.aggregate([{ $match: { } },
 { $group: { _id: "$movieid", total: { $avg: "$rating" } } }, 
  { $sort: { _id: -1 } }
  ])
                   
                   
                   
  var mapFunction1 = function() {
                         print("J76 Mapper");
        emit(this.movieid, this.rating);  
                          };

                  
 var reduceFunction1 = function(movieid, valuesrating) {
                          print("J76 Reducer");
                          return Array.avg(valuesrating);
                      };
                      
                      
db.movierating.mapReduce(
                     mapFunction1,
                     reduceFunction1,
                     { out: "map_reduce_example" }
                   )                      
