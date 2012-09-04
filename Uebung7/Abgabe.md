Author: Sascha Gennrich, Felix-Johannes Jendrusch, Johannes Klick (Gruppe 8)

<https://github.com/acer2k/gst2012/blob/master/Uebung7/Abgabe.md>

## Aufgabe 1: Vergleich JUnit & TTCN-3

### Möglichkeiten zur Testspezifikation

Testspezifikation setzt sich zusammen aus der Spezifikation abstrakter und konkreter Testfälle (vgl. Kapitel 2, Folien 56--59). JUnit ermöglicht lediglich die Implementierung (in Java) und Ausführung (auf JVM) konkreter Testfälle. TTCN-3 dagegen ist eine Testspezifikations- und Testimplementierungssprache.

### unterstütze Technologien des Testobjekts

JUnit ist ein Testframework für Java. Abgesehen von einigen Spezialfällen (z.B., Scala), kann JUnit ausschließlich zum Testen von Java-Programmen genutzt werden. TTCN-3 dagegen ist durch System- und Plattform-Adapter völlig unabhängig vom System Under Test (SUT) und der unterliegenden Plattform (vgl. Kapitel 8 (TTCN-3), Folie 36).

### Verteilungsmöglichkeiten der Tests

JUnit bietet keine Unterstützung zur Implementierung verteiler Tests. TTCN-3 dagegen unterstützt die Spezifikation verteilter Tests (vgl. Kapitel 8 (TTCN-3), Folie 12).

### (mögliche) Teststufen

JUnit eignet sich zur Implementierung von Komponenten- und Integrationstests. TTCN-3 dagegen adressiert den kompletten Entwicklungszyklus: Von Komponenten- über Integrations- bis hin zu Systemtests (vgl. Kapitel 8 (TTCN-3), Folie 23).

### Anmerkung

Es ist anzumerken, dass JUnit keinen Ausschluss für die zusätzliche Funktionalität von TTCN-3 darstellt. Natürlich kann auch mit JUnit ein verteilter Test geschrieben werden, allerdings bietet das Testframework dafür keine Unterstützung.

## Aufgabe 2

Ausführung leider nicht problemfrei (Beispiel):

	!SESSION 2012-09-04 22:12:57.172 -----------------------------------------------
	eclipse.buildId=unknown
	java.version=1.7.0_07
	java.vendor=Oracle Corporation
	BootLoader constants: OS=win32, ARCH=x86_64, WS=win32, NL=en_US
	Command-line arguments:  -os win32 -ws win32 -arch x86_64

	!ENTRY org.eclipse.core.resources 4 567 2012-09-04 22:13:08.047
	!MESSAGE Workspace restored, but some problems occurred.
	!SUBENTRY 1 org.eclipse.core.resources 4 567 2012-09-04 22:13:08.047
	!MESSAGE Could not read metadata for 'TTCN-3 Standard'.
	!STACK 1
	org.eclipse.core.internal.resources.ResourceException: The project description file (.project) for 'TTCN-3 Standard' is missing.  This file contains important information about the project.  The project will not function properly until this file is restored.
	 at org.eclipse.core.internal.localstore.FileSystemResourceManager.read(FileSystemResourceManager.java:851)
	 at org.eclipse.core.internal.resources.SaveManager.restoreMetaInfo(SaveManager.java:873)
	 at org.eclipse.core.internal.resources.SaveManager.restoreMetaInfo(SaveManager.java:853)
	 at org.eclipse.core.internal.resources.SaveManager.restore(SaveManager.java:702)
	 at org.eclipse.core.internal.resources.SaveManager.startup(SaveManager.java:1527)
	 at org.eclipse.core.internal.resources.Workspace.startup(Workspace.java:2503)
	 at org.eclipse.core.internal.resources.Workspace.open(Workspace.java:2251)
	 at org.eclipse.core.resources.ResourcesPlugin.start(ResourcesPlugin.java:439)
	 at org.eclipse.osgi.framework.internal.core.BundleContextImpl$1.run(BundleContextImpl.java:711)
	 at java.security.AccessController.doPrivileged(Native Method)
	 at org.eclipse.osgi.framework.internal.core.BundleContextImpl.startActivator(BundleContextImpl.java:702)
	 at org.eclipse.osgi.framework.internal.core.BundleContextImpl.start(BundleContextImpl.java:683)
	 at org.eclipse.osgi.framework.internal.core.BundleHost.startWorker(BundleHost.java:381)
	 at org.eclipse.osgi.framework.internal.core.AbstractBundle.start(AbstractBundle.java:299)
	 at org.eclipse.osgi.framework.util.SecureAction.start(SecureAction.java:440)
	 at org.eclipse.osgi.internal.loader.BundleLoader.setLazyTrigger(BundleLoader.java:268)
	 at org.eclipse.core.runtime.internal.adaptor.EclipseLazyStarter.postFindLocalClass(EclipseLazyStarter.java:107)
	 at org.eclipse.osgi.baseadaptor.loader.ClasspathManager.findLocalClass(ClasspathManager.java:462)
	 at org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader.findLocalClass(DefaultClassLoader.java:216)
	 at org.eclipse.osgi.internal.loader.BundleLoader.findLocalClass(BundleLoader.java:400)
	 at org.eclipse.osgi.internal.loader.SingleSourcePackage.loadClass(SingleSourcePackage.java:35)
	 at org.eclipse.osgi.internal.loader.BundleLoader.findClassInternal(BundleLoader.java:473)
	 at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:429)
	 at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:417)
	 at org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader.loadClass(DefaultClassLoader.java:107)
	 at java.lang.ClassLoader.loadClass(Unknown Source)
	 at org.eclipse.ui.internal.ide.application.IDEApplication.start(IDEApplication.java:124)
	 at org.eclipse.equinox.internal.app.EclipseAppHandle.run(EclipseAppHandle.java:196)
	 at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.runApplication(EclipseAppLauncher.java:110)
	 at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.start(EclipseAppLauncher.java:79)
	 at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:344)
	 at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:179)
	 at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	 at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	 at java.lang.reflect.Method.invoke(Unknown Source)
	 at org.eclipse.equinox.launcher.Main.invokeFramework(Main.java:622)
	 at org.eclipse.equinox.launcher.Main.basicRun(Main.java:577)
	 at org.eclipse.equinox.launcher.Main.run(Main.java:1410)
	 at org.eclipse.equinox.launcher.Main.main(Main.java:1386)
	!SUBENTRY 2 org.eclipse.core.resources 4 567 2012-09-04 22:13:08.049
	!MESSAGE The project description file (.project) for 'TTCN-3 Standard' is missing.  This file contains important information about the project.  The project will not function properly until this file is restored.

	!ENTRY org.eclipse.ui 4 0 2012-09-04 22:13:12.377
	!MESSAGE Problems occurred restoring workbench.
	!SUBENTRY 1 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 1 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 1 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 1 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 1 org.eclipse.ui 4 0 2012-09-04 22:13:12.377
	!MESSAGE Unable to restore perspective: Workspace - Java.
	!SUBENTRY 2 org.eclipse.ui 0 0 2012-09-04 22:13:12.377
	!MESSAGE Problems occurred restoring perspective.
	!SUBENTRY 3 org.eclipse.ui 0 0 2012-09-04 22:13:12.377
	!MESSAGE
	!SUBENTRY 2 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 2 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 2 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 2 unknown 0 0 2012-09-04 22:13:12.377
	!MESSAGE OK
	!SUBENTRY 2 org.eclipse.ui 4 4 2012-09-04 22:13:12.377
	!MESSAGE Could not create view: com.testingtech.ttworkbench.ttman.views.PropertiesView
	!STACK 1
	org.eclipse.ui.PartInitException: Could not create view: com.testingtech.ttworkbench.ttman.views.PropertiesView
	 at org.eclipse.ui.internal.ViewFactory.createView(ViewFactory.java:158)
	 at org.eclipse.ui.internal.Perspective.createReferences(Perspective.java:1249)
	 at org.eclipse.ui.internal.Perspective.restoreState(Perspective.java:1219)
	 at org.eclipse.ui.internal.WorkbenchPage$17.runWithException(WorkbenchPage.java:3293)
	 at org.eclipse.ui.internal.StartupThreading$StartupRunnable.run(StartupThreading.java:31)
	 at org.eclipse.swt.widgets.RunnableLock.run(RunnableLock.java:35)
	 at org.eclipse.swt.widgets.Synchronizer.runAsyncMessages(Synchronizer.java:135)
	 at org.eclipse.swt.widgets.Display.runAsyncMessages(Display.java:4140)
	 at org.eclipse.swt.widgets.Display.readAndDispatch(Display.java:3757)
	 at org.eclipse.ui.application.WorkbenchAdvisor.openWindows(WorkbenchAdvisor.java:803)
	 at org.eclipse.ui.internal.Workbench$33.runWithException(Workbench.java:1595)
	 at org.eclipse.ui.internal.StartupThreading$StartupRunnable.run(StartupThreading.java:31)
	 at org.eclipse.swt.widgets.RunnableLock.run(RunnableLock.java:35)
	 at org.eclipse.swt.widgets.Synchronizer.runAsyncMessages(Synchronizer.java:135)
	 at org.eclipse.swt.widgets.Display.runAsyncMessages(Display.java:4140)
	 at org.eclipse.swt.widgets.Display.readAndDispatch(Display.java:3757)
	 at org.eclipse.ui.internal.Workbench.runUI(Workbench.java:2604)
	 at org.eclipse.ui.internal.Workbench.access$4(Workbench.java:2494)
	 at org.eclipse.ui.internal.Workbench$7.run(Workbench.java:674)
	 at org.eclipse.core.databinding.observable.Realm.runWithDefault(Realm.java:332)
	 at org.eclipse.ui.internal.Workbench.createAndRunWorkbench(Workbench.java:667)
	 at org.eclipse.ui.PlatformUI.createAndRunWorkbench(PlatformUI.java:149)
	 at org.eclipse.ui.internal.ide.application.IDEApplication.start(IDEApplication.java:123)
	 at org.eclipse.equinox.internal.app.EclipseAppHandle.run(EclipseAppHandle.java:196)
	 at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.runApplication(EclipseAppLauncher.java:110)
	 at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.start(EclipseAppLauncher.java:79)
	 at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:344)
	 at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:179)
	 at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 at sun.reflect.NativeMethodAccessorImpl.invoke..
