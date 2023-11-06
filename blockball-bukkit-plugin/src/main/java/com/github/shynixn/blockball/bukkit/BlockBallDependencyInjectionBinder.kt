package com.github.shynixn.blockball.bukkit

import com.github.shynixn.blockball.api.business.enumeration.PluginDependency
import com.github.shynixn.blockball.api.business.enumeration.Version
import com.github.shynixn.blockball.api.business.proxy.PluginProxy
import com.github.shynixn.blockball.api.business.service.*
import com.github.shynixn.blockball.api.persistence.repository.ArenaRepository
import com.github.shynixn.blockball.api.persistence.repository.LinkSignRepository
import com.github.shynixn.blockball.bukkit.logic.business.service.*
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_13_R2.Particle113R2ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_13_R2.RayTracingService113R2Impl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_17_R1.InternalVersionPacket117R1ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_17_R1.ScreenMessage117R1ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_18_R1.InternalVersionPacket118R1ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_18_R2.InternalVersionPacket118R2ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_19_R1.InternalVersionPacket119R1ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_19_R2.InternalVersionPacket119R2ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_19_R3.InternalVersionPacket119R3ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_20_R1.InternalVersionPacket120R1ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_8_R3.InternalVersionPacket18R3ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_8_R3.Particle18R3ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_8_R3.RayTracingService18R3Impl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_8_R3.ScreenMessage18R3ServiceImpl
import com.github.shynixn.blockball.bukkit.logic.business.service.nms.v1_9_R2.InternalVersionPacket19R2ServiceImpl
import com.github.shynixn.blockball.core.logic.business.service.*
import com.github.shynixn.blockball.core.logic.persistence.repository.ArenaFileRepository
import com.github.shynixn.blockball.core.logic.persistence.repository.LinkSignFileRepository
import com.google.inject.AbstractModule
import com.google.inject.Scopes
import org.bukkit.plugin.Plugin

/**
 * BlockBall dependency locator.
 */
class BlockBallDependencyInjectionBinder(private val plugin: BlockBallPlugin) : AbstractModule() {

    /**
     * Configures the business logic tree.
     */
    override fun configure() {
        val version = plugin.getServerVersion()
        val dependencyService = DependencyServiceImpl()

        bind(Plugin::class.java).toInstance(plugin)
        bind(Version::class.java).toInstance(version)
        bind(PluginProxy::class.java).toInstance(plugin)
        bind(LoggingService::class.java).toInstance(LoggingUtilServiceImpl(plugin.logger))

        // Repositories
        bind(ArenaRepository::class.java).to(ArenaFileRepository::class.java).`in`(Scopes.SINGLETON)
        bind(LinkSignRepository::class.java).to(LinkSignFileRepository::class.java).`in`(Scopes.SINGLETON)

        // Services
        bind(EventService::class.java).to(EventServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(TemplateService::class.java).to(TemplateServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(VirtualArenaService::class.java).to(VirtualArenaServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(ScoreboardService::class.java).to(ScoreboardServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(UpdateCheckService::class.java).to(UpdateCheckServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(ConfigurationService::class.java).to(ConfigurationServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(SoundService::class.java).to(SoundServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(BossBarService::class.java).to(BossBarServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(GameService::class.java).to(GameServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(GameActionService::class.java).to(GameActionServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(GameHubGameActionService::class.java).to(GameHubGameActionServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(GameMiniGameActionService::class.java).to(GameMiniGameActionServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(GameBungeeCordGameActionService::class.java).to(GameBungeeCordGameActionServiceImpl::class.java)
            .`in`(Scopes.SINGLETON)
        bind(GameSoccerService::class.java).to(GameSoccerServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(RightclickManageService::class.java).to(RightclickManageServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(HubGameForcefieldService::class.java).to(HubGameForcefieldServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(BungeeCordService::class.java).to(BungeeCordServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(BungeeCordConnectionService::class.java).to(BungeeCordConnectionServiceImpl::class.java)
            .`in`(Scopes.SINGLETON)
        bind(BallEntityService::class.java).to(BallEntityServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(BlockSelectionService::class.java).to(BlockSelectionServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(YamlSerializationService::class.java).to(YamlSerializationServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(YamlService::class.java).to(YamlServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(ItemTypeService::class.java).to(ItemTypeServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(ConcurrencyService::class.java).to(ConcurrencyServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(ProxyService::class.java).to(ProxyServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(CommandService::class.java).to(CommandServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(GameExecutionService::class.java).to(GameExecutionServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(PersistenceLinkSignService::class.java).to(PersistenceLinkSignServiceImpl::class.java)
            .`in`(Scopes.SINGLETON)
        bind(PersistenceArenaService::class.java).to(PersistenceArenaServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(DependencyBossBarApiService::class.java).to(DependencyBossBarApiServiceImpl::class.java)
            .`in`(Scopes.SINGLETON)
        bind(DependencyService::class.java).to(DependencyServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(PlaceholderService::class.java).to(PlaceholderServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(PacketService::class.java).to(PacketJavaProtocolServiceImpl::class.java).`in`(Scopes.SINGLETON)
        bind(ProtocolService::class.java).to(ProtocolServiceImpl::class.java).`in`(Scopes.SINGLETON)

        when {
            version.isVersionSameOrGreaterThan(Version.VERSION_1_13_R2)
            -> bind(RayTracingService::class.java).to(RayTracingService113R2Impl::class.java)
                .`in`(Scopes.SINGLETON)
            else -> bind(RayTracingService::class.java).to(RayTracingService18R3Impl::class.java)
                .`in`(Scopes.SINGLETON)
        }

        when {
            version.isVersionSameOrGreaterThan(Version.VERSION_1_17_R1)
            -> bind(ScreenMessageService::class.java).to(ScreenMessage117R1ServiceImpl::class.java)
                .`in`(Scopes.SINGLETON)
            else -> bind(ScreenMessageService::class.java).to(ScreenMessage18R3ServiceImpl::class.java)
                .`in`(Scopes.SINGLETON)
        }

        when {
            version.isVersionSameOrGreaterThan(Version.VERSION_1_20_R1) ->
                bind(InternalVersionPacketService::class.java).to(InternalVersionPacket120R1ServiceImpl::class.java)
                    .`in`(Scopes.SINGLETON)
            version.isVersionSameOrGreaterThan(Version.VERSION_1_19_R3) ->
                bind(InternalVersionPacketService::class.java).to(InternalVersionPacket119R3ServiceImpl::class.java)
                    .`in`(Scopes.SINGLETON)
            version.isVersionSameOrGreaterThan(Version.VERSION_1_19_R2) ->
                bind(InternalVersionPacketService::class.java).to(InternalVersionPacket119R2ServiceImpl::class.java)
                    .`in`(Scopes.SINGLETON)
            version.isVersionSameOrGreaterThan(Version.VERSION_1_19_R1) ->
                bind(InternalVersionPacketService::class.java).to(InternalVersionPacket119R1ServiceImpl::class.java)
                    .`in`(Scopes.SINGLETON)
            version.isVersionSameOrGreaterThan(Version.VERSION_1_18_R2) ->
                bind(InternalVersionPacketService::class.java).to(InternalVersionPacket118R2ServiceImpl::class.java)
                    .`in`(Scopes.SINGLETON)
            version.isVersionSameOrGreaterThan(Version.VERSION_1_18_R1) ->
                bind(InternalVersionPacketService::class.java).to(InternalVersionPacket118R1ServiceImpl::class.java)
                    .`in`(Scopes.SINGLETON)
            version.isVersionSameOrGreaterThan(Version.VERSION_1_17_R1) ->
                bind(InternalVersionPacketService::class.java).to(InternalVersionPacket117R1ServiceImpl::class.java)
                    .`in`(Scopes.SINGLETON)
            version.isVersionSameOrGreaterThan(Version.VERSION_1_9_R1)
            -> bind(InternalVersionPacketService::class.java).to(InternalVersionPacket19R2ServiceImpl::class.java)
                .`in`(Scopes.SINGLETON)
            else -> bind(InternalVersionPacketService::class.java).to(InternalVersionPacket18R3ServiceImpl::class.java)
                .`in`(Scopes.SINGLETON)
        }

        when {
            version.isVersionSameOrGreaterThan(Version.VERSION_1_13_R2) -> bind(ParticleService::class.java).to(
                Particle113R2ServiceImpl::class.java
            ).`in`(
                Scopes.SINGLETON
            )
            else -> bind(ParticleService::class.java).to(Particle18R3ServiceImpl::class.java).`in`(Scopes.SINGLETON)
        }

        if (dependencyService.isInstalled(PluginDependency.PLACEHOLDERAPI)) {
            bind(DependencyPlaceholderApiService::class.java).to(DependencyPlaceholderApiServiceImpl::class.java)
        }

        if (dependencyService.isInstalled(PluginDependency.VAULT)) {
            bind(DependencyVaultService::class.java).to(DependencyVaultServiceImpl::class.java).`in`(Scopes.SINGLETON)
        }
    }
}
