
                 
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
                   
                   
 var reduceFunction1 = function(movieid, valuesrating) {
                          return Array.avg(valuesrating);
                      };
                      
                      
db.movierating.mapReduce(
                     mapFunction1,
                     reduceFunction1,
                     { out: "map_reduce_example" }
                   )                      
