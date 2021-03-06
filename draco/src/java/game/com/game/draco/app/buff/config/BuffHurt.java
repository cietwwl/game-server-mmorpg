package com.game.draco.app.buff.config;

import sacred.alliance.magic.util.KeySupport;
import lombok.Data;

public @Data
class BuffHurt {

	// buffID
	private short buffId;

	// 加或减
	private byte reduce;

	// 伤害类型
	private byte hurtType;

	// 万分比
	private int a;

	// 技能相关
	private int b;

	// 附加值
	private int d;

	// 自己还是目标
	private byte targetType;

	// 属性类型
	private byte attrType;

	//修改目标类型
	private byte modifyTargetType;
	
	//修改目标的属性类型
	private byte modifyTargetAttr;
	
	//描述
	private String des;
	
	//属性 0 攻击1 加血2
	private byte damage;

}
