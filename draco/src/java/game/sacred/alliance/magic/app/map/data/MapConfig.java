//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.25 at 09:55:35 下午 CST 
//


package sacred.alliance.magic.app.map.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import sacred.alliance.magic.app.map.MapProperty;
import sacred.alliance.magic.base.MapLogicType;
import sacred.alliance.magic.util.LongTool;


/**
 * <p>Java class for MapConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="maplogicid" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="samecampcanpk" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="diffcampcanpk" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="cantroop" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="copymode" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="deathjumpmapid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reloginjumpmapid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maporiginx" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maporiginy" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maptype" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="mapweather" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="mapconfig")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapConfig")
public @Data class MapConfig {

    @XmlAttribute
    protected int maplogicid;
    //@XmlAttribute
    //protected boolean samecampcanpk;
    //@XmlAttribute
    //protected boolean diffcampcanpk;
    @XmlAttribute
    protected boolean cantroop;
    @XmlAttribute
    protected byte logictype;//MapLogicType类型标识
    @XmlAttribute
    protected String deathjumpmapid;
    @XmlAttribute
    protected String reloginjumpmapid;
    @XmlAttribute
    protected int maporiginx;//安全点
    @XmlAttribute
    protected int maporiginy;//安全点
    @XmlAttribute
    protected byte maptype;
    @XmlAttribute
    protected byte mapweather;
    @XmlAttribute
    protected String maplevelname; //关卡名
    @XmlAttribute
    protected String mapdisplayname;
    @XmlAttribute
    protected String mapgroundres ;//地图资源
    //@XmlAttribute
    //protected int mapmusicindex = -1 ;
    //@XmlAttribute
    //protected byte isEquestrian = 1;// 是否能使用骑术技能，0：不能，1：能
    
    private boolean hadLineMap = false; //是否为分线地图
    private int maxRoleCount = -1;//地图支持最大人数（-1：不受人数限制）
    private int maxLineCount = -1; //地图最大分线数目(-1：不受限制)
    private int lifeCycle = 120; //地图无玩家时的销毁间隔时间（单位：秒）
    
    private short copyId = -1; //副本ID
    
    private short smallMapResId ; //小地图资源ID,从配置表中获得
    private int minTransLevel ; //传输级别
    private int maxTransLevel ; //传输级别
    private int weatherTimes = -1 ; 
    private byte showExit ; //是否显示出口
    private byte npcPK ; //npc是否可PK
    private int broadcastAllMax = 0;
    private int changeLine;//是否允许变线
    private byte roleCanPK;//是否可以强制PK 0否 1是
    private byte switchHero  ; //是否允许切换英雄
    private byte useFood ;
    private byte hpHealth ;
    private byte canChange3Hero ;
    private byte canHook ;
    private byte canOnHorse ;
    private byte canQuickVoice ;
	private byte canSituReborn ;
	private byte canSoulReborn ;
	private byte canShowQuest ;
	private byte canShowTeam ;
	private byte canLearnPk ;
	private byte voiceChannelType ;
	private byte mapMusic ;
	/**
	 * 不同公会是否可PK
	 */
	private byte diffUnionCanPK = 0 ;
    private byte showWorldMap = 1 ;
    private byte showMenu = 1 ;
    private byte showFriendNpcHp = 0 ;
    
    public boolean isPvpMap(){
    	return  this.roleCanPK == 1 || diffUnionCanPK == 1;
    }
    
	/**
	 * 判断地图类型是否为副本地图
	 * @return
	 */
	public boolean iscopymode(){
		return MapLogicType.isCopyType(this.logictype);
	}
	
	
	public MapLogicType getMapLogicType(){
		return MapLogicType.getMapLogicType(this.logictype);
	}
	
	public boolean changeLogicType(MapLogicType type){
		if(null == type){
			return false ;
		}
		if(this.logictype == MapLogicType.defaultLogic.getType()
				|| this.logictype == type.getType()){
			this.logictype = (byte)type.getType() ;
			return true ;
		}
		return false ;
	}
	
	
	public int getMapPropertyValue(int mpProp){
		if(MapProperty.canRolePk.getType() == mpProp){
			return this.getRoleCanPK() ;
		}
		if(MapProperty.showExit.getType() == mpProp){
			return this.getShowExit() ;
		}
		if(MapProperty.canOnHorse.getType() == mpProp){
			return this.getCanOnHorse() ;
		}
		if(MapProperty.canSwitchHero.getType() == mpProp){
			return this.getSwitchHero() ;
		}
		if(MapProperty.canUseFood.getType() == mpProp){
			return this.getUseFood() ;
		}
		if(MapProperty.canHpHealth.getType() == mpProp){
			return this.getHpHealth() ;
		}
		if(MapProperty.canChange3Hero.getType() == mpProp){
			return this.getCanChange3Hero() ;
		}
		if (MapProperty.canShowFatigue.getType() == mpProp) {
			return this.getMapLogicType().getType() == MapLogicType.defaultLogic
					.getType() ? 1 : 0;
		}
		if(MapProperty.canHook.getType() == mpProp){
			return this.getCanHook() ;
		}
		if(MapProperty.canQuickVoice.getType() == mpProp){
			return this.getCanQuickVoice() ;
		}
		if(MapProperty.canShowQuest.getType() == mpProp){
			return this.getCanShowQuest() ;
		}
		if(MapProperty.canShowTeam.getType() == mpProp){
			return this.getCanShowTeam() ;
		}
        if(MapProperty.showWorldMap.getType() == mpProp){
            return this.getShowWorldMap() ;
        }
        if(MapProperty.showMenu.getType() == mpProp){
            return this.getShowMenu() ;
        }
        if(MapProperty.showFriendNpcHp.getType() == mpProp){
            return this.getShowFriendNpcHp();
        }
		return 0 ;
	}
	
	
	public int getMapProperty (){
		long value = 0 ;
		for(MapProperty mp : MapProperty.values()){
			if(1 == this.getMapPropertyValue(mp.getType())){
				value = LongTool.setIndexValueOne(value, mp.getType()) ;
			}
		}
		return (int)value ;
	}

}
