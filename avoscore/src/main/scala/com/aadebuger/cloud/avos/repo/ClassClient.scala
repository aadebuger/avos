package com.aadebuger.cloud.avos.repo

/**
 * Created with IntelliJ IDEA.
 * User: aadebuger
 * Date: 13-9-4
 * Time: 上午11:15
 * To change this template use File | Settings | File Templates.
 */
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.Date
import com.mongodb.DBObject;
import com.aadebuger.cloud.avos.util._

import org.bson.types.ObjectId;
class ClassClient {


  def addClass(collectname:String, obj:DBObject) =
  {

    var col=AvosUtil.getCollection(collectname);
    obj.put("created",new Date());

    col.save(obj);
    true;
  }
  def getClass( collectname:String , id:String) =
  {
    var col=AvosUtil.getCollection(collectname)
    col.findOne(new BasicDBObject("_id",new ObjectId(id)))

  }
  def updateClass( collectname:String , id:String,obj: DBObject) =
  {
    var col=AvosUtil.getCollection(collectname)

    col.update(new BasicDBObject().append("_id", new ObjectId(id)),new BasicDBObject("$set",obj))
  }
  def queryClass( collectname:String, queryobj:DBObject) =
  {
    var col=AvosUtil.getCollection(collectname)
    val obj=col.find(queryobj);
      obj.toArray()
  }
  def deleteClass(collectname:String, id:String)
  {
    var col=AvosUtil.getCollection(collectname)
    col.remove(new BasicDBObject().append("_id", new ObjectId(id)));
  }

}
