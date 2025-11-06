<template>
    <component
        :is="isExternal ? 'a' : 'router-link'"
        :href="isExternal ? to : null"
        :to="!isExternal ? to : null"
        :target="isExternal ? '_blank' : null"
            :class="['link-componant', `link-componant--${variant}`]"
     >
        <slot>{{ label }}</slot>
  </component>
</template>

<script lang="ts" setup>
    const props =  defineProps({
        to: {
            type: String,
            required: true, // L’URL ou la route
        },
        label: {
            type: String,
            default: "",
        },
        
    })

</script>

<style>

.linkComponent {
  text-decoration: none;
  display: inline-block;
  border-radius: 6px;
  transition: all 0.2s ease;
  font-weight: 500;
}
</style>