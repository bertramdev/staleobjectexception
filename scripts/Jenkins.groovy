includeTargets << grailsScript("_GrailsBootstrap")
includeTargets << grailsScript("_PluginDependencies")
includeTargets << grailsScript("_GrailsWar")
target(jenkins:"Clean, Refresh Deps, Build War") {
    depends(clean, resolveDependencies, war)
}


setDefaultTarget("jenkins")