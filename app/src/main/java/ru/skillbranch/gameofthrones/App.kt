package ru.skillbranch.gameofthrones

import android.app.Application
import android.content.Context
import ru.skillbranch.gameofthrones.di.*
import ru.skillbranch.gameofthrones.di.modules.AndroidModule
import ru.skillbranch.gameofthrones.di.modules.CharacterModule
import ru.skillbranch.gameofthrones.di.modules.ListModule
import ru.skillbranch.gameofthrones.di.modules.SplashModule

//  у Макеева RootActivity: AppCompatActivity()
class App2 : Application() {

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    private fun createComponent() {
        component = DaggerApplicationComponent
            .builder()
            .androidModule(AndroidModule(this))
            .build()
    }


    companion object {
        lateinit var component: ApplicationComponent

        var splashSubComponent: SplashSubComponent? = null
            get() {
                field ?: return component.plus(SplashModule())
                return field
            }

        var listSubComponent: ListSubComponent? = null
            get() {
                field ?: return component.plus(ListModule())
                return field
            }

        var characterSubComponent: CharacterSubComponent? = null
            get() {
                field ?: return component.plus(CharacterModule())
                return field
            }


        fun releaseSplashSubComponent() {
            splashSubComponent = null
        }

        fun releaseListSubComponent() {
            listSubComponent = null
        }

        fun releaseCharacterSubComponent() {
            characterSubComponent = null
        }

        fun get(context: Context): App2 = context.applicationContext as App2
    }

}