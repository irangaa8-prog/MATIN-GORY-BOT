package com.matin.gorybot
import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.widget.*
class MainActivity : Activity() {
 private val bg=Color.rgb(8,9,13); private val panel=Color.rgb(18,20,27); private val red=Color.rgb(255,23,68); private val muted=Color.rgb(165,174,190); private lateinit var root:LinearLayout
 override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);window.statusBarColor=bg;window.navigationBarColor=bg;showHome()}
 private fun dp(v:Int)=(v*resources.displayMetrics.density).toInt()
 private fun shape(c:Int,s:Int=0)=GradientDrawable().apply{setColor(c);cornerRadius=dp(16).toFloat();if(s!=0)setStroke(dp(1),s)}
 private fun txt(v:String,size:Float,c:Int,b:Boolean=false)=TextView(this).apply{text=v;textSize=size;setTextColor(c);if(b)setTypeface(null,Typeface.BOLD);gravity=Gravity.CENTER_VERTICAL}
 private fun btn(v:String,f:()->Unit)=Button(this).apply{text=v;setTextColor(Color.WHITE);textSize=14f;background=shape(red);isAllCaps=false;setOnClickListener{f()}}
 private fun base(sub:String){root=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setPadding(dp(18),dp(16),dp(18),dp(16));setBackgroundColor(bg)};setContentView(ScrollView(this).apply{addView(root)});root.addView(txt("👑  MATIN GORY BOT",23f,red,true));root.addView(txt(sub,14f,muted).apply{setPadding(0,dp(4),0,dp(18))})}
 private fun card(t:String,b:String){val box=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setPadding(dp(16),dp(14),dp(16),dp(14));background=shape(panel,Color.rgb(90,20,38))};box.addView(txt(t,16f,Color.WHITE,true));box.addView(txt(b,14f,muted).apply{setPadding(0,dp(8),0,0)});root.addView(box,LinearLayout.LayoutParams(-1,-2).apply{bottomMargin=dp(12)})}
 private fun addBtn(s:String,f:()->Unit){root.addView(btn(s,f),LinearLayout.LayoutParams(-1,dp(52)));root.addView(View(this),LinearLayout.LayoutParams(1,dp(10)))}
 private fun showHome(){base("FREE FIRE GUILD COMPANION");card("GUILD GLORY","Track guild statistics here. Live game data is not connected.");card("BOT STATUS","Demo dashboard • No game automation is running");addBtn("Guild & Glory Stats"){showStats()};addBtn("Bot Control Panel"){showBotInfo()};addBtn("Settings & Safety"){showSettings()};root.addView(txt("More Glory, Stronger Guild",13f,red,true).apply{gravity=Gravity.CENTER})}
 private fun showStats(){base("GUILD & GLORY STATISTICS");card("Guild Name","Not connected");card("Total Glory","— Connect an authorised data source to show real stats.");card("Members","— No member data loaded.");addBtn("← Back to Home"){showHome()}}
 private fun showBotInfo(){base("BOT CONTROL PANEL");card("Account Controls","This starter app does not log in to Free Fire, collect passwords, or control game accounts.");card("Auto Join / Match Play","Not enabled. Use only official, permitted integrations; this app does not automate gameplay.");card("Next Step","A real integration needs a legitimate supported API or authorised backend. Do not upload guest.dat or account credentials to unknown services.");addBtn("← Back to Home"){showHome()}}
 private fun showSettings(){base("SETTINGS");card("Appearance","Dark background • Neon red theme");card("App Version","MATIN GORY BOT 1.0 • Starter build");card("Privacy","This starter app stores no credentials and makes no network requests.");addBtn("← Back to Home"){showHome()}}
}
